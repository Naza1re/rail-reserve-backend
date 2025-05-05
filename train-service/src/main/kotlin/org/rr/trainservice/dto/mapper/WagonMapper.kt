package org.rr.trainservice.dto.mapper

import org.mapstruct.Mapper
import org.rr.trainservice.dto.request.WagonRequest
import org.rr.trainservice.dto.response.WagonResponse
import org.rr.trainservice.model.Wagon

@Mapper(componentModel = "spring")
interface WagonMapper {

    fun toEntity(request: WagonRequest): Wagon
    fun toResponse(save: Wagon): WagonResponse
}