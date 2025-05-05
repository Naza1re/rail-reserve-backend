package org.rr.trainservice.model

import jakarta.persistence.*

@Entity
@Table(name = "station")
data class Station(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    val name: String,
    val code: String,
    val city: String
)
