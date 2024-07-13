package io.github.tainafernandes.bankproject.application.entity

data class Address(
    val street: String,
    val number: String,
    val complement: String,
    val cep: String
)
