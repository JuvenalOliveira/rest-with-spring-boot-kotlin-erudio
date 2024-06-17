package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

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
}
