package br.vehicle_registration.database.entities

import br.vehicle_registration.models.dtos.VehicleDTO
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "vehicles")
data class Vehicle (
    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue
    val id: UUID? = null,

    @Column(name = "make")
    var make: String = String(),

    @Column(name = "model")
    var model: String = String(),

    @Column(name = "license_plate")
    var licensePlate: String = String(),

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id")
    val owner: Account,

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    constructor(account: Account, vehicleDTO: VehicleDTO) : this(
        owner = account,
        id = vehicleDTO.id?.let { UUID.fromString(it) },
        make = vehicleDTO.make,
        model = vehicleDTO.model,
        licensePlate = vehicleDTO.licensePlate,
    )

    fun updateWith(vehicleDTO: VehicleDTO): Vehicle {
        assert(this.id.toString() == vehicleDTO.id)
        this.make = vehicleDTO.make
        this.model = vehicleDTO.model
        this.licensePlate = vehicleDTO.licensePlate
        return this
    }
}
