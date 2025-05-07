package org.rr.trainservice.dto.request

import java.time.LocalTime

data class RouteStopRequest(
    val stationId: Long,
    val arrivalTime: LocalTime,
    val departureTime: LocalTime,
    val stopOrder: Int

)