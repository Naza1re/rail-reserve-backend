package org.rr.trainservice.service

import org.rr.trainservice.dto.TrainResponse
import org.rr.trainservice.mapper.TrainMapper
import org.rr.trainservice.model.Train
import org.rr.trainservice.repository.TrainRepository
import org.springframework.stereotype.Service

@Service
class TrainService(private val trainRepository: TrainRepository,
                   private val trainMapper: TrainMapper) {

    fun getTrainById(id: Long): TrainResponse {
        return trainMapper.toResponse(trainRepository.findById(id).orElseThrow())
    }

    fun getAllTrains(): List<Train> {
        return trainRepository.findAll()
    }
}