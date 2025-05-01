package org.rr.trainservice.model

import jakarta.persistence.*

@Entity
@Table(name = "train")
data class Train(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val type: String,

    @OneToMany(mappedBy = "train", cascade = [CascadeType.ALL])
    val wagons: List<Wagon> = emptyList()
)
