package org.rr.trainservice.dto.mapper

import org.mapstruct.Mapper
import org.rr.trainservice.dto.request.StationRequest
import org.rr.trainservice.dto.response.StationResponse
import model.Station

@Mapper(componentModel = "spring")
interface StationMapper {

    fun toResponse(station: Station) : StationResponse
    fun toEntity(request: StationRequest): Station
}