package org.rr.trainservice.model

import jakarta.persistence.*

@Entity
@Table(name = "wagon")
data class Wagon(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val number: Int,
    val type: String,
    val seatCount: Int,

    @ManyToOne
    val train: Train
)