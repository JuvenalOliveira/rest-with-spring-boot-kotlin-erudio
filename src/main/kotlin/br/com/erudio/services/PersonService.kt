package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person>{ //vai listar todos os usuarios da lista

        logger.info("Procurando uma pessoa")
        return repository.findAll()
    }

    fun findById(id: Long): Person{ //procura uma pessoa por ID
        logger.info("Procurando uma pessoa") //logger.info serve para enviar uma mensagem

        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
    }
    fun create(person: Person) : Person{
        logger.info("Creating one person with name ${person.primeiroNome}")
       return repository.save(person)
    }

    fun update(person: Person) : Person{
        logger.info("Updating one person with ID ${person.id}")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        person.primeiroNome = person.primeiroNome
        person.ultimoNome = person.ultimoNome
        person.addres = person.addres
        person.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}
