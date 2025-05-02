package org.rr.trainservice.dto.request

data class TrainRequest(
    val name: String,
    val type: String,
    val wagonsId: List<Long>
)