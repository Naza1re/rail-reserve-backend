package org.rr.trainservice.model.extensions

import model.Route
import model.RouteStop

fun List<RouteStop>.assignToRoute(route: Route): List<RouteStop> {
    forEach { it.route = route }
    route.stops.addAll(this)
    return this
}