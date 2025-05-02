package org.rr.trainservice.service

import org.rr.trainservice.dto.mapper.StationMapper
import org.rr.trainservice.dto.request.StationRequest
import org.rr.trainservice.dto.response.StationResponse
import org.rr.trainservice.exception.StationNotFoundException
import org.rr.trainservice.model.Station
import org.rr.trainservice.repository.StationRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StationService(private val stationRepository : StationRepository,
                    private val stationMapper: StationMapper
) {

    fun getStationById(id: Long) : Station {
        return getStationOrThrow(id)
    }

    @Transactional(readOnly = true)
    fun findStationById(id: Long): StationResponse {
        return stationMapper.toResponse(getStationOrThrow(id))
    }

    fun getStationOrThrow(id: Long) : Station {
        return stationRepository.findById(id).orElseThrow {
            StationNotFoundException("Station with id $id not found")
        }
    }

    @Transactional(readOnly = true)
    fun getAllStations(page: Int, size: Int): Page<Station> {
        return stationRepository.findAll(PageRequest.of(page, size))
    }

    @Transactional
    fun createStation(request: StationRequest): StationResponse {
        val station = stationMapper.toEntity(request)
        return stationMapper.toResponse(stationRepository.save(station))
    }

    @Transactional
    fun deleteStation(id: Long) {
        val station = getStationOrThrow(id)
        stationRepository.delete(station)
    }

    @Transactional
    fun updateStation(id: Long, stationRequest: StationRequest): StationResponse {
        val station = getStationOrThrow(id)
        val updateStation = stationMapper.toEntity(stationRequest)
        updateStation.id = station.id
        return stationMapper.toResponse(stationRepository.save(station))
    }
}