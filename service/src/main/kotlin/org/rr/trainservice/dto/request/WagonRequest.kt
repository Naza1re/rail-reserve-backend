package org.rr.trainservice.dto.request

data class WagonRequest(
    val number: Int,
    val type: String,
    val seatCount: Int,
)