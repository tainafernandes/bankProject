package io.github.tainafernandes.bankproject.domain.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.math.BigDecimal

@Entity
data class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var name: String,
    var accountValue: BigDecimal,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id", referencedColumnName = "id")
    var address: AddressEntity
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ClientEntity

        return id == other.id
    }

    override fun hashCode(): Int = hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , accountValue = $accountValue , address = $address )"
    }
}
