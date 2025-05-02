package org.rr.trainservice.controller

import org.rr.trainservice.dto.request.StationRequest
import org.rr.trainservice.dto.response.StationResponse
import org.rr.trainservice.model.Station
import org.rr.trainservice.service.StationService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/stations")
class StationController(private val stationService: StationService) {

    @GetMapping
    fun getAllStations(@RequestParam size: Int,
                       @RequestParam page: Int) : ResponseEntity<Page<Station>> {
        return ResponseEntity.ok(stationService.getAllStations(page, size))
    }

    @GetMapping("/{id}")
    fun getStationById(@PathVariable id: Long): ResponseEntity<StationResponse> {
        return ResponseEntity.ok(stationService.findStationById(id))
    }

    @PostMapping
    fun crateStation(@RequestBody request: StationRequest): ResponseEntity<StationResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(stationService.createStation(request))
    }

    @DeleteMapping("/{id}")
    fun deleteStation(@PathVariable id: Long): ResponseEntity<Void> {
        stationService.deleteStation(id)
        return ResponseEntity.ok().build()
    }

    @PutMapping("/{id}")
    fun updateStation(@PathVariable id: Long,
                      @RequestBody stationRequest: StationRequest): ResponseEntity<StationResponse> {
        return ResponseEntity.ok(stationService.updateStation(id, stationRequest))
    }


}