package org.rr.trainservice.service

import org.springframework.transaction.annotation.Transactional
import org.rr.trainservice.dto.mapper.RouteMapper
import org.rr.trainservice.dto.request.RouteRequest
import org.rr.trainservice.dto.response.RouteResponse
import org.rr.trainservice.exception.RouteNotFoundException
import org.rr.trainservice.model.Route
import org.rr.trainservice.model.extensions.assignToRoute
import org.rr.trainservice.repository.RouteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class RouteService(private val routeStopService: RouteStopService,
                   private val routeRepository: RouteRepository,
                   private val stationService: StationService,
                   private val routeMapper: RouteMapper,

) {

    @Transactional(readOnly = true)
    fun findAll(page: Int, size: Int) : Page<Route> {
        val pageRequest = PageRequest.of(page, size)
        return routeRepository.findAll(pageRequest)
    }

    @Transactional(readOnly = true)
    fun getRouById(id: Long) : RouteResponse {
        val route = getRoutOrThrow(id)
        return routeMapper.toResponse(route)
    }

    @Transactional
    fun createRouteByRequest(request: RouteRequest) : RouteResponse {
        val route = routeMapper.toEntity(request)

        fillRouteWithFields(route, request)

        return routeMapper.toResponse(routeRepository.save(route))
    }

    @Transactional
    fun updateRouteById(id: Long, request: RouteRequest): RouteResponse {
        val existingRoute = getRoutOrThrow(id)

        existingRoute.stops.clear()
        existingRoute.durationMinutes = request.durationMinutes

        fillRouteWithFields(existingRoute, request)
        return routeMapper.toResponse(routeRepository.save(existingRoute))
    }


    fun fillRouteWithFields(route: Route, request: RouteRequest) {
        val routeStops = routeStopService.createRouteStops(request.stops)
        val fromStation = stationService.getStationById(request.fromStationId)
        val toStation = stationService.getStationById(request.toStationId)

        routeStops.assignToRoute(route)

        route.fromStation = fromStation
        route.toStation = toStation
    }

    private fun getRoutOrThrow(id: Long) : Route {
        return routeRepository.findById(id).orElseThrow{
            RouteNotFoundException("Route with id $id not found")
        }
    }

    @Transactional
    fun deleteRoute(id: Long) {
        val routeToDelete = getRoutOrThrow(id)
        routeRepository.delete(routeToDelete)
    }

}
