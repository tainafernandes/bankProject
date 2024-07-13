package io.github.tainafernandes.bankproject.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.Hibernate

@Entity
data class AddressModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val street: String,
    val number: String,
    val complement: String,
    val cep: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as AddressModel

        return id == other.id
    }

    override fun hashCode(): Int = hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , street = $street , number = $number , complement = $complement , cep = $cep )"
    }
}
