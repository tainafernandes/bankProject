package io.github.tainafernandes.bankproject.domain.repository

import io.github.tainafernandes.bankproject.domain.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<AddressEntity, Long>