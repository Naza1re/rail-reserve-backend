package org.rr.trainservice.model

import jakarta.persistence.*

@Entity
@Table(name = "train")
data class Train(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var name: String,

    var type: String,

    @OneToMany(mappedBy = "train", cascade = [CascadeType.ALL])
    var wagons: List<Wagon> = emptyList()
)
