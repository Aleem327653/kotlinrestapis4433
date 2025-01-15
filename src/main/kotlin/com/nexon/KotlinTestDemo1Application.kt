package com.nexon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinTestDemo1Application

fun main(args: Array<String>) {
	runApplication<KotlinTestDemo1Application>(*args)
	println("Project Started ........ ")
}
