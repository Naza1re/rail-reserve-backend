package org.rr.trainservice.dto

data class TrainRequest(
    val name: String,

    val type: String,

    val wagonsId: List<Long>
)