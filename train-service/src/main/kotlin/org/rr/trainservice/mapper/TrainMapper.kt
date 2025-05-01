package org.rr.trainservice.mapper

import org.mapstruct.Mapper
import org.rr.trainservice.dto.TrainRequest
import org.rr.trainservice.dto.TrainResponse
import org.rr.trainservice.model.Train

@Mapper(componentModel = "spring")
interface TrainMapper {

    fun toResponse(train: Train): TrainResponse
    fun toEntity(request: TrainRequest): Train
}