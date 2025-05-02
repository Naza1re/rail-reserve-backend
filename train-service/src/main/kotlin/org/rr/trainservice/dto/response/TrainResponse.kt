package org.rr.trainservice.dto.response

class TrainResponse (
    val id: Long = 0,
    val name: String,
    val type: String,
    val wagons: List<WagonResponse>
)