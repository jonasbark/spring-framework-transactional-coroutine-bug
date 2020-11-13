package com.example.demo

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	lateinit var test: TestHandlerInterface

	@Test
	fun contextLoads() {
		val test = runBlocking {
			TestTest(test.test())
		}
		println(test)
	}

}
