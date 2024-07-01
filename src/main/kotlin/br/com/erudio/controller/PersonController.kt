package br.com.erudio.controller

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.data.vo.v2.PersonVO as PersonVOV2
import br.com.erudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController //criando um bean
@RequestMapping("/person")
class PersonController {

    val contador: AtomicLong = AtomicLong()

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE]) //GetMapping é um RequestMapping vom o request.method ja inserido.
        fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value = "id") id: Long): PersonVO {
        return service.findById(id)
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE],
                 consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: PersonVO): PersonVO {
        return service.create(person)

    }   @PostMapping(value = ["/v2"],produces = [MediaType.APPLICATION_JSON_VALUE],
                 consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createV2(@RequestBody person: PersonVOV2): PersonVOV2 {
        return service.createV2(person)
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON_VALUE],
                consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: PersonVO): PersonVO {
        return service.update(person)
    }
    @DeleteMapping(value = ["/{id}"],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long) : ResponseEntity<*>{
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
//@RequestBody serve para enviar parametros via post.



}