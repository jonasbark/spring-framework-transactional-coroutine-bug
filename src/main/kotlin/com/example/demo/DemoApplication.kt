package com.example.demo

import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@Service
class TestHandler : TestHandlerInterface {

    override suspend fun test() = "Hello"
}

@Transactional
interface TestHandlerInterface {
    suspend fun test(): String
}

data class TestTest(val string: String)

@Controller
class Test {
    @Autowired
    lateinit var handler: TestHandlerInterface

    @RequestMapping(value = ["/test/"], method = [RequestMethod.GET])
    @ResponseBody
    suspend fun test() = handler.test()
}
