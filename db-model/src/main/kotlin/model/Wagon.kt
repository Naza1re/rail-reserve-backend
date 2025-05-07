package model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "wagon")
data class Wagon(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    val number: Int,
    val type: String,
    val seatCount: Int,

    @ManyToOne
    @JsonIgnore
    var train: Train
)