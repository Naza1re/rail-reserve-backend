package org.rr.trainservice.service

import org.rr.trainservice.dto.mapper.RouteStopMapper
import org.rr.trainservice.dto.request.RouteStopRequest
import model.RouteStop
import repository.RouteStopRepository
import org.springframework.stereotype.Service

@Service
class RouteStopService(private val routeStopRepository: RouteStopRepository,
                       private val stationService: StationService,
                       private val routeMapper: RouteStopMapper) {

    fun createRouteStops(routeStopsRequest: List<RouteStopRequest>) : List<RouteStop> {
        val routeStops = ArrayList<RouteStop>()
        for( routeStop in routeStopsRequest) {
            val existStation = stationService.getStationById(routeStop.stationId)
            val routeStopToSave = routeMapper.toEntity(routeStop)
            routeStopToSave.station = existStation
            routeStops.add(routeStopToSave)
        }
        return routeStopRepository.saveAll(routeStops)
    }

}