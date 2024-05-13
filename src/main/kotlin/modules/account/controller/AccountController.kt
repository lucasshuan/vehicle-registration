package br.vehicle_registration.modules.account.controller

import br.vehicle_registration.database.entities.Account
import br.vehicle_registration.models.dtos.AccountDTO
import br.vehicle_registration.modules.account.service.AccountService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/accounts")
@Validated
class AccountController(
    private val accountService: AccountService
) {
    @GetMapping("{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getVehicle(
        @PathVariable id: String
    ): Account = accountService.getAccountById(UUID.fromString(id))

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getAccounts(): List<Account> = accountService.getAccounts()

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun createAccount(
        @Valid @RequestBody accountDTO: AccountDTO
    ): Account = accountService.createAccount(accountDTO)

    @DeleteMapping("{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun deleteAccount(@PathVariable id: UUID) = accountService.deleteAccount(id)
}
