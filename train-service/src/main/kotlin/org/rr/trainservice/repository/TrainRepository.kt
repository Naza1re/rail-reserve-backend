package org.rr.trainservice.repository

import org.rr.trainservice.model.Train
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface TrainRepository : JpaRepository<Train, Long>, JpaSpecificationExecutor<Train> {
}