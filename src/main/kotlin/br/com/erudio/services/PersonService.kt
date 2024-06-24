package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person>{ //vai listar todos os usuarios da lista

        logger.info("Procurando uma pessoa")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0 .. 7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons

    }

    fun findById(id: Long): Person{ //procura uma pessoa por ID
        logger.info("Procurando uma pessoa")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.primeiroNome = "Ryan"
        person.ultimoNome = "Oliveira"
        person.addres = "Viela 25 de março - São Paulo"
        person.gender = "Masculino"
        return person
    }
    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {

    }

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.primeiroNome = "Nome da pessoa: $i"
        person.ultimoNome = "Ultimo nome: $i"
        person.addres = "Mora no Brasil"
        person.gender = "Masculino"
        return person
    }
}
