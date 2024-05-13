package br.vehicle_registration.modules.vehicle.service

import br.vehicle_registration.database.entities.Vehicle
import br.vehicle_registration.models.dtos.VehicleDTO
import java.util.UUID

interface VehicleService {
    fun getVehicleById(id: UUID): Vehicle
    fun getVehicles(): List<Vehicle>
    fun createVehicle(ownerId: UUID, vehicleDTO: VehicleDTO): Vehicle
    fun deleteVehicle(id: UUID)
}