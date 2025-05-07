package org.rr.trainservice.dto.response

import java.time.LocalTime

data class RouteStopResponse(
    val id: Long,
    val station: StationResponse?,
    val arrivalTime: LocalTime,
    val departureTime: LocalTime,
    val stopOrder: Int
)