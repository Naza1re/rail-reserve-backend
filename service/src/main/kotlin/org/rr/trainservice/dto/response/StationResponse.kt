package org.rr.trainservice.dto.response

data class StationResponse(
    val id: Long,
    val name: String,
    val code: String,
    val city: String
)