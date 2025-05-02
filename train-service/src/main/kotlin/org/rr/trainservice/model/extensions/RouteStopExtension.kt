package org.rr.trainservice.model.extensions

import org.rr.trainservice.model.Route
import org.rr.trainservice.model.RouteStop

fun List<RouteStop>.assignToRoute(route: Route): List<RouteStop> {
    forEach { it.route = route }
    route.stops.addAll(this)
    return this
}