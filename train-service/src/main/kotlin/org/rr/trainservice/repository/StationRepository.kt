package org.rr.trainservice.repository

import org.rr.trainservice.model.Station
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StationRepository : JpaRepository<Station, Long>, JpaSpecificationExecutor<Station> {
}