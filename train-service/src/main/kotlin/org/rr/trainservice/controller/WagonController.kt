package org.rr.trainservice.controller

import org.rr.trainservice.dto.request.WagonRequest
import org.rr.trainservice.dto.response.WagonResponse
import org.rr.trainservice.model.Wagon
import org.rr.trainservice.service.WagonService
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
@RequestMapping("/api/v1/wagons")
class WagonController(private val wagonService: WagonService) {


    @GetMapping
    fun getAllWagons(@RequestParam size: Int,
                     @RequestParam page: Int): ResponseEntity<Page<Wagon>> {
        return ResponseEntity.ok(wagonService.getAllWagons(page, size))
    }

    @GetMapping("/{id}")
    fun getWagonById(@PathVariable id: Long): ResponseEntity<Wagon> {
        return ResponseEntity.ok(wagonService.getWagonById(id))
    }

    @PostMapping
    fun crateWagon(wagonRequest: WagonRequest) : ResponseEntity<WagonResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(wagonService.createWagon(wagonRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteWagonById(@PathVariable id: Long): ResponseEntity<Void> {
        wagonService.deleteWagonById(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateWagonById(@PathVariable id: Long,
                        @RequestBody wagonRequest: WagonRequest) : ResponseEntity<WagonResponse> {
        return ResponseEntity.ok(wagonService.updateWagonByd(id, wagonRequest))
    }

}