package br.vehicle_registration.database.repositories

import br.vehicle_registration.database.entities.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.UUID

interface AccountRepository : JpaRepository<Account, UUID>, JpaSpecificationExecutor<Account>