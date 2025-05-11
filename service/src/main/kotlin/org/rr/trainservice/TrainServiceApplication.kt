package org.rr.trainservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["model"])
@EnableJpaRepositories(
	"repository"
)
class TrainServiceApplication

fun main(args: Array<String>) {
	runApplication<TrainServiceApplication>(*args)
}
