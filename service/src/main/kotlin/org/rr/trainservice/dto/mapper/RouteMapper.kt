package org.rr.trainservice.dto.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.rr.trainservice.dto.request.RouteRequest
import org.rr.trainservice.dto.response.RouteResponse
import org.rr.trainservice.model.Route

@Mapper(componentModel = "spring")
interface RouteMapper {

    fun toResponse(route: Route) : RouteResponse

    @Mapping(target = "stops", expression = "java(new java.util.ArrayList<>())")
    fun toEntity(request: RouteRequest) : Route
}