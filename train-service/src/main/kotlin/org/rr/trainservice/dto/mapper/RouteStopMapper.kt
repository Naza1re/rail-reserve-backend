package org.rr.trainservice.dto.mapper

import org.mapstruct.Mapper
import org.rr.trainservice.dto.request.RouteStopRequest
import org.rr.trainservice.model.RouteStop

@Mapper(componentModel = "spring")
interface RouteStopMapper {

    fun toEntity(routeStopRequest: RouteStopRequest) : RouteStop
}