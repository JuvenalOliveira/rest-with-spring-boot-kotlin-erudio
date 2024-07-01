package br.com.erudio.mapper.custom
import br.com.erudio.data.vo.v2.PersonVO
import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToVo(person: Person): PersonVO{
        val vo = PersonVO()
        vo.id = person.id
        vo.addres = person.addres
        vo.birthDay = Date()
        vo.primeiroNome = person.primeiroNome
        vo.ultimoNome = person.ultimoNome
        vo.gender = person.gender
        return vo
    }
    fun mapVOToEntity(person: PersonVO): Person{
        val entity = Person()
        entity.id = person.id
        entity.addres = person.addres
        //entity.birthDay = person.birthDay
        entity.primeiroNome = person.primeiroNome
        entity.ultimoNome = person.ultimoNome
        entity.gender = person.gender
        return entity
    }
}