package org.rr.trainservice.repository

import org.rr.trainservice.model.Route
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RouteRepository : JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {

    @Query("SELECT r FROM Route r WHERE r.id IN :ids")
    fun findByRoutesId(@Param("ids") ids: List<Long>): List<Route>
}