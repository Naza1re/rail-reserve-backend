package org.rr.trainservice.service

import jakarta.transaction.Transactional
import model.Train
import model.Wagon
import org.rr.trainservice.dto.request.TrainRequest
import org.rr.trainservice.dto.response.TrainResponse
import org.rr.trainservice.exception.TrainNotFoundException
import org.rr.trainservice.exception.WagonAlreadyAssignedOrNotFoundException
import org.rr.trainservice.dto.mapper.TrainMapper
import org.rr.trainservice.model.extensions.assignTo
import repository.TrainRepository
import repository.WagonRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TrainService(private val trainRepository: TrainRepository,
                   private val trainMapper: TrainMapper,
                   private val wagonRepository: WagonRepository
) {

    fun getTrainById(id: Long): TrainResponse {
        return trainMapper.toResponse(trainRepository.findById(id).orElseThrow())
    }

    fun getAllTrains(size: Int, page: Int): Page<Train> {
        val pageable: Pageable = PageRequest.of(page, size)
        return trainRepository.findAll(pageable)
    }

    @Transactional
    fun createTrainByRequest(request: TrainRequest): TrainResponse {
        val train = trainMapper.toEntity(request)
        val wagons = wagonRepository.findUnassignedWagonsByIds(request.wagonsId)
        validateWagonsRequest(wagons, request)

        wagons.assignTo(train)

        return trainMapper.toResponse(trainRepository.save(train))
    }

    fun deleteTrainById(id: Long) {
        val existTrain = getTrainOrThrow(id)
        trainRepository.delete(existTrain)
    }

    private fun validateWagonsRequest(foundWagons: List<Wagon>, req: TrainRequest) {
        if (foundWagons.size != req.wagonsId.size) {
            val missingIds = req.wagonsId.toSet() - foundWagons.map { it.id }.toSet()
            throw WagonAlreadyAssignedOrNotFoundException(
                "Wagon(s) with ids ${missingIds.joinToString()} do not exist or are already assigned to another train"
            )
        }
    }

    fun getTrainOrThrow(id: Long): Train {
        return trainRepository.findById(id).orElseThrow{
            TrainNotFoundException("Train with id $id not found")
        }
    }

    fun updateTrainByRequest(id: Long, request: TrainRequest): TrainResponse {
        val train = getTrainOrThrow(id)
        val trainToSave = trainMapper.toEntity(request)
        trainToSave.id = train.id
        return trainMapper.toResponse(trainRepository.save(train))
    }
}
