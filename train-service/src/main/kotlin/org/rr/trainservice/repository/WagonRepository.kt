package org.rr.trainservice.repository

import org.rr.trainservice.model.Wagon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface WagonRepository : JpaRepository<Wagon, Long>, JpaSpecificationExecutor<Wagon> {

    @Query("SELECT w FROM Wagon w WHERE w.id IN :ids AND w.train IS NULL")
    fun findUnassignedWagonsByIds(@Param("ids") ids: List<Long>): List<Wagon>
}