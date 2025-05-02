package org.rr.trainservice.model

import jakarta.persistence.*

@Entity
data class Route(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    var fromStation: Station?,

    @ManyToOne
    var toStation: Station?,

    var durationMinutes: Int,

    @OneToMany(mappedBy = "route", cascade = [CascadeType.ALL], orphanRemoval = true)
    var stops: MutableList<RouteStop> = mutableListOf()
)
