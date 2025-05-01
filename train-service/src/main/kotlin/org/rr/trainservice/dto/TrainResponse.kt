package org.rr.trainservice.dto

import org.rr.trainservice.model.Wagon

class TrainResponse (
    val id: Long = 0,
    val name: String,
    val type: String,
    val wagons: List<Wagon> = emptyList()
)