package repository

import model.Station
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface StationRepository : JpaRepository<Station, Long>, JpaSpecificationExecutor<Station> {
}