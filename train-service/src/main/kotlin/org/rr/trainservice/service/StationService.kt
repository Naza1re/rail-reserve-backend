package org.rr.trainservice.service

import org.rr.trainservice.exception.StationNotFoundException
import org.rr.trainservice.model.Station
import org.rr.trainservice.repository.StationRepository
import org.springframework.stereotype.Service

@Service
class StationService(private val stationRepository : StationRepository) {

    fun getStationById(id: Long) : Station {
        return getStationOrThrow(id)
    }

    private fun getStationOrThrow(id: Long) : Station {
        return stationRepository.findById(id).orElseThrow {
            StationNotFoundException("Station with id $id not found")
        }
    }
}