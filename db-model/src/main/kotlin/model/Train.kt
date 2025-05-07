package model

import jakarta.persistence.*

@Entity
@Table(name = "train")
data class Train(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var name: String,

    var type: String,

    @OneToMany(mappedBy = "train", cascade = [CascadeType.ALL], orphanRemoval = true)
    var wagons: MutableList<Wagon> = mutableListOf()
)
