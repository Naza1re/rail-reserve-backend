package org.rr.trainservice.model.extensions

import model.Train
import model.Wagon

fun List<Wagon>.assignTo(train: Train): List<Wagon> {
    forEach { it.train = train }
    train.wagons.addAll(this)
    return this
}