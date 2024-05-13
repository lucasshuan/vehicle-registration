package br.vehicle_registration.database.repositories

import br.vehicle_registration.database.entities.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.UUID

interface VehicleRepository : JpaRepository<Vehicle, UUID>, JpaSpecificationExecutor<Vehicle>