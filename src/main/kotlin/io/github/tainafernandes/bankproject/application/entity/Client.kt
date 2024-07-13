package io.github.tainafernandes.bankproject.application.entity

import java.math.BigDecimal

data class Client(
    val id: Long,
    val name: String,
    val accountValue: BigDecimal,
    val address: Address
)