package br.com.erudio

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController //criando um bean
class GreetingController {

    val contador: AtomicLong = AtomicLong()

    @RequestMapping("/mensagem") //quando eu acessar o lolcalhost:8080/greeting, vai imprimir a mensagem
    fun imprimirMensagem(@RequestParam(value="name", defaultValue = "World")name: String): Greeting { //estou retornando a classe Greeting
        return Greeting(1 , "Hello, $name") //estou retornando um numero e uma string
    }
    @RequestMapping("/numero")
    fun exibirNumero(): Int{
        return 100
    }
    @RequestMapping("/letra")
    fun exibirEmNumero(): String{
        return "Este é o numero apresentado!"
    }
}