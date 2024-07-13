package io.github.tainafernandes.bankproject.domain.repository

import io.github.tainafernandes.bankproject.domain.model.ClientModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository: JpaRepository<ClientModel, Long>