package org.rr.trainservice.dto.request

data class RouteRequest(
    val fromStationId: Long,
    val toStationId: Long,
    val durationMinutes: Int,
    val stops: List<RouteStopRequest>
)