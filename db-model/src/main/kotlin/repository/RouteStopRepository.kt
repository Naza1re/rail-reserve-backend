package repository

import model.RouteStop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RouteStopRepository : JpaRepository<RouteStop, Long>, JpaSpecificationExecutor<RouteStop> {

    @Query("SELECT r FROM RouteStop r WHERE r.id IN :ids")
    fun findByIds(@Param("ids") ids: List<Long>): List<RouteStop>
}