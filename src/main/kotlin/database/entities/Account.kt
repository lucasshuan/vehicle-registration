package br.vehicle_registration.database.entities

import br.vehicle_registration.models.dtos.AccountDTO
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @Column(name = "account_id")
    @GeneratedValue
    val id: UUID? = null,

    @Column(name = "name")
    var name: String = String(),

    @Column(name = "cpf", unique = true)
    var cpf: String = String(),

    @Column(name = "email")
    var email: String = String(),

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
) : Serializable {
    constructor(accountDTO: AccountDTO) : this(
        id = accountDTO.id?.let { UUID.fromString(it) },
        cpf = accountDTO.cpf,
        name = accountDTO.name,
        email = accountDTO.email,
    )

    fun updateWith(accountDTO: AccountDTO): Account {
        assert(this.id.toString() == accountDTO.id)
        this.cpf = accountDTO.cpf
        this.name = accountDTO.name
        this.email = accountDTO.email
        return this
    }
}
