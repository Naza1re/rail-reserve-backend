package org.rr.trainservice.service

import org.rr.trainservice.dto.mapper.WagonMapper
import org.rr.trainservice.dto.request.WagonRequest
import org.rr.trainservice.dto.response.WagonResponse
import org.rr.trainservice.exception.WagonNotFoundException
import model.Wagon
import repository.WagonRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class WagonService(private val wagonRepository: WagonRepository,
                   private val wagonMapper: WagonMapper) {
    fun getAllWagons(page: Int, size: Int): Page<Wagon> {
        return wagonRepository.findAll(PageRequest.of(page, size))
    }

    fun getWagonById(id: Long): Wagon {
        return getWagonOrThrow(id)
    }

    fun getWagonOrThrow(id: Long): Wagon {
        return wagonRepository.findById(id).orElseThrow{
            WagonNotFoundException("Wagon with id $id not found")
        }
    }

    fun createWagon(wagonRequest: WagonRequest): WagonResponse {
        val wagon = wagonMapper.toEntity(wagonRequest)
        return wagonMapper.toResponse(wagonRepository.save(wagon))
    }

    fun deleteWagonById(id: Long) {
        val wagonToDelete = getWagonOrThrow(id)
        wagonRepository.delete(wagonToDelete)
    }

    fun updateWagonByd(id: Long, wagonRequest: WagonRequest): WagonResponse? {
        val wagon = getWagonOrThrow(id)
        val updatedWagon = wagonMapper.toEntity(wagonRequest)
        updatedWagon.id = wagon.id
        return wagonMapper.toResponse(wagonRepository.save(updatedWagon))
    }
}