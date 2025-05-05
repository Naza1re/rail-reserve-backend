package org.rr.trainservice.model.extensions

import org.rr.trainservice.model.Train
import org.rr.trainservice.model.Wagon

fun List<Wagon>.assignTo(train: Train): List<Wagon> {
    forEach { it.train = train }
    train.wagons.addAll(this)
    return this
}