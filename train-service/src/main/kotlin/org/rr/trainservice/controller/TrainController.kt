package org.rr.trainservice.controller

import org.rr.trainservice.dto.TrainResponse
import org.rr.trainservice.model.Train
import org.rr.trainservice.service.TrainService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/trains")
class TrainController(val trainService: TrainService) {


    @GetMapping
    fun getAllTrains() : List<Train>{
        return trainService.getAllTrains()
    }

    @GetMapping("/{id}")
    fun getTrainById(@PathVariable id: Long): TrainResponse {
        return trainService.getTrainById(id)
    }


}