package org.rr.trainservice.controller

import org.rr.trainservice.dto.request.RouteRequest
import org.rr.trainservice.dto.response.RouteResponse
import model.Route
import org.rr.trainservice.service.RouteService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/api/v1/routs")
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