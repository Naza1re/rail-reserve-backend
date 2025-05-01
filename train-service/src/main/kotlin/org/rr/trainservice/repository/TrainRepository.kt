package org.rr.trainservice.repository

import org.rr.trainservice.model.Train
import org.springframework.data.jpa.repository.JpaRepository

interface TrainRepository : JpaRepository<Train, Long> {
}