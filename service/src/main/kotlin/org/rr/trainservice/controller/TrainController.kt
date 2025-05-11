package org.rr.trainservice.controller

import org.rr.trainservice.dto.request.TrainRequest
import org.rr.trainservice.dto.response.TrainResponse
import model.Train
import org.rr.trainservice.service.TrainService
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
@RequestMapping("/api/v1/trains")
class TrainController(private val trainService: TrainService) {

    @GetMapping
    fun getAllTrains(@RequestParam size: Int,
                     @RequestParam page: Int) : Page<Train> {
        return trainService.getAllTrains(size, page)
    }

    @GetMapping("/{id}")
    fun getTrainById(@PathVariable id: Long): ResponseEntity<TrainResponse> {
        return ResponseEntity.ok(trainService.getTrainById(id))
    }

    @PostMapping
    fun crateTrain(@RequestBody request: TrainRequest) : ResponseEntity<TrainResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(trainService.createTrainByRequest(request))
    }

    @DeleteMapping("/{id}")
    fun deleteTrain(@PathVariable id: Long) : ResponseEntity<Void> {
        trainService.deleteTrainById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @PutMapping("/{id}")
    fun updateTrain(@PathVariable id: Long,
                    @RequestBody request: TrainRequest
    ) : ResponseEntity<TrainResponse> {
        return ResponseEntity.ok(trainService.updateTrainByRequest(id, request))
    }
}