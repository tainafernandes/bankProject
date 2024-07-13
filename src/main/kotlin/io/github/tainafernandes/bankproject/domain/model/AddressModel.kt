package io.github.tainafernandes.bankproject.domain.model

data class AddressModel(
    val street: String,
    val number: String,
    val complement: String,
    val cep: String
)
