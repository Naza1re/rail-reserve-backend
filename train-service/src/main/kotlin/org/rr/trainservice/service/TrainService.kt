package org.rr.trainservice.service

import jakarta.transaction.Transactional
import org.rr.trainservice.dto.TrainRequest
import org.rr.trainservice.dto.TrainResponse
import org.rr.trainservice.exception.TrainNotFoundException
import org.rr.trainservice.exception.WagonAlreadyAssignedException
import org.rr.trainservice.mapper.TrainMapper
import org.rr.trainservice.model.Train
import org.rr.trainservice.model.Wagon
import org.rr.trainservice.repository.TrainRepository
import org.rr.trainservice.repository.WagonRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TrainService(private val trainRepository: TrainRepository,
                   private val trainMapper: TrainMapper,
                    private val wagonRepository: WagonRepository) {

    fun getTrainById(id: Long): TrainResponse {
        return trainMapper.toResponse(trainRepository.findById(id).orElseThrow())
    }

    fun getAllTrains(size: Int, page: Int): Page<Train> {
        val pageable: Pageable = PageRequest.of(page, size)
        return trainRepository.findAll(pageable)
    }

    @Transactional
    fun createTrainByRequest(request: TrainRequest): TrainResponse {
        var train = trainMapper.toEntity(request)
        var wagons = wagonRepository.findUnassignedWagonsByIds(request.wagonsId)
        validateWagonsRequest(wagons, request)

        return trainMapper.toResponse(trainRepository.save(train))
    }

    fun deleteTrainById(id: Long) {
        val existTrain = trainRepository.findById(id).orElseThrow {
            TrainNotFoundException("Train with id $id not found")
        }
        trainRepository.delete(existTrain)
    }

    private fun validateWagonsRequest(foundWagons: List<Wagon>, req: TrainRequest) {
        val requestedIds = req.wagonsId.toSet()
        val foundIds = foundWagons.map { it.id }.toSet()

        val alreadyAssignedIds = requestedIds - foundIds

        if (alreadyAssignedIds.isNotEmpty()) {
            throw  WagonAlreadyAssignedException("Wagon(s) with ids ${alreadyAssignedIds.joinToString()} already assigned")
        }
    }
}