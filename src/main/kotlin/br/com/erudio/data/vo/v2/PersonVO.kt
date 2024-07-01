package br.com.erudio.data.vo.v2
import java.util.Date

data class PersonVO (

    var id: Long = 0,
    var primeiroNome: String = "", //nullable diz que o campo nao pode ser null, e o lenght informa o tanto de caractere
    var ultimoNome: String = "",
    var addres: String = "",
    var gender: String = "",
    var birthDay: Date? = null
)