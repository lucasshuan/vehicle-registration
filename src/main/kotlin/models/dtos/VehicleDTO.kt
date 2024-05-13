package br.vehicle_registration.models.dtos

import br.vehicle_registration.database.entities.Vehicle
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.*

data class VehicleDTO (
    @JsonProperty("id")
    val id: String?,

    @JsonProperty("make")
    var make: String,

    @JsonProperty("model")
    var model: String,

    @JsonProperty("licensePlate")
    @NotBlank(message = "licensePlate is required")
    var licensePlate: String,

    @JsonProperty("ownerId")
    @NotBlank(message = "ownerId is required")
    var ownerId: String,
) {
    constructor(vehicle: Vehicle) : this(
        id = vehicle.id.toString(),
        make = vehicle.make,
        model = vehicle.model,
        licensePlate = vehicle.licensePlate,
        ownerId = vehicle.owner.id.toString()
    )
}
