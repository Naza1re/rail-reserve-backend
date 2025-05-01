package org.rr.trainservice.model

import jakarta.persistence.*

@Entity
data class Route(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    val fromStation: Station,

    @ManyToOne
    val toStation: Station,

    val durationMinutes: Int,

    @OneToMany(mappedBy = "route", cascade = [CascadeType.ALL])
    val stops: List<RouteStop> = emptyList()
)
