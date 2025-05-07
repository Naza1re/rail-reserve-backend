package repository

import model.Train
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface TrainRepository : JpaRepository<Train, Long>, JpaSpecificationExecutor<Train> {
}