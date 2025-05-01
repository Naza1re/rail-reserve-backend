package org.rr.trainservice.model

import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "route_stop")
data class RouteStop(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    val route: Route,

    @ManyToOne
    val station: Station,

    val arrivalTime: LocalTime,
    val departureTime: LocalTime,
    val stopOrder: Int
)
