package org.rr.trainservice.controller

import org.rr.trainservice.dto.request.RouteRequest
import org.rr.trainservice.dto.response.RouteResponse
import org.rr.trainservice.model.Route
import org.rr.trainservice.service.RouteService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/routing")
class RouteController(private val routeService: RouteService) {

    @GetMapping
    fun getAllRoutes(@RequestParam size: Int,
                     @RequestParam page: Int): Page<Route> {
        return routeService.findAll(page, size)
    }

    @GetMapping("/{id}")
    fun getRouteById(@PathVariable id: Long): ResponseEntity<RouteResponse> {
        return ResponseEntity.ok(routeService.getRouById(id))
    }

    @PostMapping
    fun createRouteByRequest(@RequestBody request: RouteRequest): ResponseEntity<RouteResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.createRouteByRequest(request))
    }

    @PutMapping("/{id}")
    fun updateRouteById(@PathVariable id: Long, @RequestBody request: RouteRequest): ResponseEntity<RouteResponse> {
        return ResponseEntity.ok(routeService.updateRouteById(id, request))
    }

    @DeleteMapping("/{id}")
    fun deleteRouteById(@PathVariable id: Long): ResponseEntity<Void> {
        routeService.deleteRoute(id)
        return ResponseEntity.noContent().build()
    }
}