package org.rr.trainservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrainServiceApplication

fun main(args: Array<String>) {
	runApplication<TrainServiceApplication>(*args)
}
