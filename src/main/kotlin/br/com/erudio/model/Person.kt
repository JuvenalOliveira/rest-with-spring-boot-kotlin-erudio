package br.com.erudio.model

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //acrescenta o valor 1 ao Id, fazendo com que ele nunca se repita.
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80) //aqui estou criando as tabelas do banco de dados
    var primeiroNome: String = "", //nullable diz que o campo nao pode ser null, e o lenght informa o tanto de caractere

    @Column(name = "last_name", nullable = false, length = 80)
    var ultimoNome: String = "",

    @Column(nullable = false, length = 100)
    var addres: String = "",

    @Column(nullable = false, length = 6)
    var gender: String = ""
)
