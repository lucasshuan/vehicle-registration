package br.vehicle_registration.modules.vehicle.controller

import br.vehicle_registration.database.entities.Account
import br.vehicle_registration.database.entities.Vehicle
import br.vehicle_registration.models.dtos.AccountDTO
import br.vehicle_registration.models.dtos.VehicleDTO
import br.vehicle_registration.modules.account.service.AccountService
import br.vehicle_registration.modules.vehicle.service.VehicleService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/vehicles")
@Validated
class VehicleController(
    private val vehicleService: VehicleService
) {
    @GetMapping("{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getVehicle(
        @PathVariable id: String
    ): Vehicle = vehicleService.getVehicleById(UUID.fromString(id))

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getVehicles(): List<Vehicle> = vehicleService.getVehicles()

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun createVehicle(
        @Valid @RequestBody vehicleDTO: VehicleDTO
    ): Vehicle {
        val ownerId = UUID.fromString(vehicleDTO.ownerId)
        return vehicleService.createVehicle(ownerId, vehicleDTO)
    }

    @DeleteMapping("{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun deleteVehicle(@PathVariable id: UUID) = vehicleService.deleteVehicle(id)
}