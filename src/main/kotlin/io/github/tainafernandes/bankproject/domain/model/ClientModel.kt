package io.github.tainafernandes.bankproject.domain.model

import io.github.tainafernandes.bankproject.application.entity.Address
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.math.BigDecimal

data class ClientModel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "name")
    val name: String,
    @Column(name= "accountValue")
    val accountValue: BigDecimal,
    @OneToOne
    val address: Address
)
