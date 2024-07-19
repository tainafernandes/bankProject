package io.github.tainafernandes.bankproject.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.Hibernate

@Entity
data class AddressEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var street: String,
    var number: String,
    var complement: String,
    var cep: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as AddressEntity

        return id == other.id
    }

    override fun hashCode(): Int = hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , street = $street , number = $number , complement = $complement , cep = $cep )"
    }
}
