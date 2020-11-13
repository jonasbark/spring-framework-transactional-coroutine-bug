import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
	kotlin("plugin.allopen") version "1.4.10"
	kotlin("plugin.noarg") version "1.4.10"
}
dependencyManagement {
	imports {
		mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) {
			bomProperty("kotlin.version", "1.4.10")
		}
	}
}
group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenLocal()

	mavenCentral()
}

dependencies {

	runtimeOnly("com.h2database:h2")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
	api("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.4.1")

	// COROUTINES
	api("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.0")
	testApi("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		exclude(module = "mockito-core")
	}
	testApi("org.springframework.security:spring-security-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		exclude(module = "mockito-core")
	}
	testApi("org.jetbrains.kotlin:kotlin-test")
	testApi("org.jetbrains.kotlin:kotlin-test-junit")
	testApi("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
