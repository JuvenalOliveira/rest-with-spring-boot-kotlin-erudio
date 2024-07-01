package br.com.erudio.services

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired // serve para inicializar o lateinit
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO>{ //vai listar todos os usuarios da lista

        logger.info("Finding all people!")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO{ //procura uma pessoa por ID
        logger.info("Finding one person!") //logger.info serve para enviar uma mensagem

        var person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        return DozerMapper.parseObject(person, PersonVO::class.java)

    }
    fun create(person: PersonVO) : PersonVO {
        logger.info("Creating one person with name ${person.primeiroNome}")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
       return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun update(person: PersonVO) : PersonVO{
        logger.info("Updating one person with ID ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.primeiroNome = person.primeiroNome
        entity.ultimoNome = person.ultimoNome
        entity.addres = person.addres
        entity.gender = person.gender
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}
