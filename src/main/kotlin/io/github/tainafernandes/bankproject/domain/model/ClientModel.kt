package io.github.tainafernandes.bankproject.domain.model

import io.github.tainafernandes.bankproject.application.entity.Address
import jakarta.persistence.*
import org.hibernate.Hibernate
import java.math.BigDecimal

@Entity
data class ClientModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val accountValue: BigDecimal,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id", referencedColumnName = "id")
    val address: AddressModel
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ClientModel

        return id == other.id
    }

    override fun hashCode(): Int = hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , accountValue = $accountValue , address = $address )"
    }
}
