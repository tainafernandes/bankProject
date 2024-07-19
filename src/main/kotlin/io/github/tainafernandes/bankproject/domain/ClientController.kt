package io.github.tainafernandes.bankproject.domain

import io.github.tainafernandes.bankproject.application.usecase.ClientUseCase
import io.github.tainafernandes.bankproject.domain.entity.AccountValue
import io.github.tainafernandes.bankproject.domain.entity.ClientEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.util.*


@RestController
@RequestMapping("/client")
class ClientController(
    private val useCase: ClientUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAllClients(): List<ClientEntity> {
        return useCase.findAllClients()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findClientById(@PathVariable id: Long): Optional<ClientEntity> {
        return useCase.findById(id)
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody client: ClientEntity): ClientEntity {
        return useCase.create(client)
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody client: ClientEntity, @PathVariable id: Long): ClientEntity {
        return useCase.updateClient(id, client)
    }

    @PutMapping("/putMoney/{id}")
    @ResponseStatus(HttpStatus.OK)
    //TODO - PENSAR JUNTO COM A NAT MANEIRA PARA MELHORAR ISSO
    fun putMoney(@RequestBody value: AccountValue, @PathVariable id: Long): ClientEntity {
        return useCase.putMoney(value, id)
    }

    @PutMapping("/withdraw/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun withdrawMoney(@RequestBody value: AccountValue, @PathVariable id: Long): ClientEntity {
        return useCase.withdrawMoney(value, id)
    }
}