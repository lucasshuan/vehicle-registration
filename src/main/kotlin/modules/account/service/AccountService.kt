package br.vehicle_registration.modules.account.service

import br.vehicle_registration.database.entities.Account
import br.vehicle_registration.models.dtos.AccountDTO
import java.util.UUID

interface AccountService {
    fun getAccountById(id: UUID): Account
    fun getAccounts(): List<Account>
    fun createAccount(accountDTO: AccountDTO): Account
    fun deleteAccount(id: UUID)
}