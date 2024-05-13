package br.vehicle_registration.models.dtos

import br.vehicle_registration.database.entities.Account
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.*

data class AccountDTO (
    @JsonProperty("id")
    val id: String?,

    @JsonProperty("name")
    @NotBlank(message = "name is required")
    var name: String,

    @JsonProperty("cpf")
    @NotBlank(message = "cpf is required")
    var cpf: String,

    @JsonProperty("email")
    @NotBlank(message = "email is required")
    @Email()
    var email: String,
) {
    constructor(account: Account) : this(
        id = account.id.toString(),
        cpf = account.cpf,
        name = account.name,
        email = account.email,
    )
}
