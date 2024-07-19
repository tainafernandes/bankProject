package io.github.tainafernandes.bankproject.application.usecase

import io.github.tainafernandes.bankproject.domain.entity.AccountValue
import io.github.tainafernandes.bankproject.domain.entity.ClientEntity
import io.github.tainafernandes.bankproject.domain.repository.ClientRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
data class ClientUseCase(
    private val repository: ClientRepository
) {
    fun findAllClients(): List<ClientEntity> {
        return repository.findAll()
    }

    fun findById(id: Long): Optional<ClientEntity> {
        return repository.findById(id)
    }

    fun create(client: ClientEntity): ClientEntity {
        return repository.save(client)
    }

    fun updateClient(id: Long, client: ClientEntity): ClientEntity {
        val clientExist = findById(id).orElseThrow {
            RuntimeException("Cliente não encontrado")
        }

        clientExist.name = client.name
        clientExist.address.street = client.address.street
        clientExist.address.number = client.address.number
        clientExist.address.complement = client.address.complement
        clientExist.address.cep = client.address.cep
        clientExist.accountValue = client.accountValue

        return repository.save(clientExist)
    }

    fun putMoney(accountValue: AccountValue, id: Long): ClientEntity {
        val clientExist = findById(id).orElseThrow {
            RuntimeException("Cliente não encontrado")
        }

        clientExist.accountValue = clientExist.accountValue.add(accountValue.value)

        return repository.save(clientExist)
    }

    fun withdrawMoney(accountValue: AccountValue, id: Long): ClientEntity {
        val clientExist = findById(id).orElseThrow {
            RuntimeException("Cliente não encontrado")
        }

        if (clientExist.accountValue < accountValue.value) {
            throw Exception("Não é possível realizar o saque, valor maior que o disponível em conta")
        }

        clientExist.accountValue = clientExist.accountValue.subtract(accountValue.value)

        return repository.save(clientExist)
    }
}
