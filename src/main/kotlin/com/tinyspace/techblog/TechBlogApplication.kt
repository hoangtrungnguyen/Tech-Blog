package com.tinyspace.techblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TechBlogApplication

fun main(args: Array<String>) {
    runApplication<TechBlogApplication>(*args)
}
