package org.rr.trainservice.dto.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.rr.trainservice.dto.request.TrainRequest
import org.rr.trainservice.dto.response.TrainResponse
import model.Train

@Mapper(componentModel = "spring")
interface TrainMapper {

    fun toResponse(train: Train): TrainResponse

    @Mapping(target = "wagons", expression = "java(new java.util.ArrayList<>())")
    fun toEntity(request: TrainRequest): Train
}