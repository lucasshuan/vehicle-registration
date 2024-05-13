package br.vehicle_registration.modules.vehicle.service

import br.vehicle_registration.database.entities.Vehicle
import br.vehicle_registration.database.repositories.VehicleRepository
import br.vehicle_registration.models.dtos.VehicleDTO
import br.vehicle_registration.modules.account.service.AccountService
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class VehicleServiceImpl(
  private val vehicleRepository: VehicleRepository,
    private val accountService: AccountService
): VehicleService {
    override fun getVehicleById(id: UUID): Vehicle {
        return vehicleRepository.findById(id).orElseThrow {-> NoSuchElementException("vehicle with id $id not found")}
    }

    override fun getVehicles(): List<Vehicle> {
        return vehicleRepository.findAll()
    }

    override fun createVehicle(ownerId: UUID, vehicleDTO: VehicleDTO): Vehicle {
        val owner = accountService.getAccountById(ownerId)
        val vehicle = Vehicle(owner, vehicleDTO)
        return vehicleRepository.save(vehicle)
    }

    override fun deleteVehicle(id: UUID) {
        vehicleRepository.deleteById(id)
    }
}