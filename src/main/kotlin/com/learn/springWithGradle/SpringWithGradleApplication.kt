package com.learn.springWithGradle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringWithGradleApplication

fun main(args: Array<String>) {
	runApplication<SpringWithGradleApplication>(*args)
}
