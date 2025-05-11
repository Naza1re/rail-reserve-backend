package org.rr.trainservice.dto.response

import model.Station

data class RouteResponse(
    val id: Long,
    val fromStation: Station,
    val toStation: Station,
    val durationMinutes: Int,
    val stops: List<RouteStopResponse>
)
