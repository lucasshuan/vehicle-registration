package br.vehicle_registration.modules.account.service

import br.vehicle_registration.database.entities.Account
import br.vehicle_registration.database.repositories.AccountRepository
import br.vehicle_registration.models.dtos.AccountDTO
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AccountServiceImpl (
    private val accountRepository: AccountRepository
): AccountService {
    override fun getAccountById(id: UUID): Account {
        return accountRepository.findById(id).orElseThrow { -> NoSuchElementException("account with id $id not found")}
    }

    override fun getAccounts(): List<Account> {
        return accountRepository.findAll()
    }

    override fun createAccount(accountDTO: AccountDTO): Account {
        val account = Account(accountDTO)
        return accountRepository.save(account)
    }

    override fun deleteAccount(id: UUID) {
        accountRepository.deleteById(id)
    }
}