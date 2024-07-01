package br.com.erudio.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("id", "addres", "primeiroNome", "ultimoNome", "gender") //muda a ordem de empressão no postman
data class PersonVO (

    var id: Long = 0,


    @field:JsonProperty("firstName") //vai imprimir no log firtName ao invez de primeiroNome.
    var primeiroNome: String = "", //nullable diz que o campo nao pode ser null, e o lenght informa o tanto de caractere
    var ultimoNome: String = "",
    var addres: String = "",

    @field:JsonIgnore //serve para ocultar uma aba, quando imprimir as mensagems, a aba (gender) vai estar ocultada.
    var gender: String = ""
)

