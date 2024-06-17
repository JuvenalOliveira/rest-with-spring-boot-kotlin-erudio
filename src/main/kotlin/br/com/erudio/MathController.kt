package br.com.erudio

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController //criando um bean
class MathController {

    val contador: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"]) //Serve para mapear um end point
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?, //@PathVariable permite que o controller lide com requesição parametrizadas
        @PathVariable(value = "numberTwo") numberTwo: String? //Como variaveis.
    ): Double {
        if(!ehNumero(numberOne) || !ehNumero(numberTwo)) throw java.lang.Exception() //criando validação
        return converterDouble(numberOne) + converterDouble(numberTwo)
    }
    public fun ehNumero(numero: String?): Boolean{
        if (numero.isNullOrBlank()) return false
        val num = numero.replace(",".toRegex(),".")
        return num.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
    public fun converterDouble(numero: String?): Double{
        if (numero.isNullOrBlank()) return 0.0 //caso numero for null retornara 0
        val num = numero.replace(",".toRegex(),".") //caso usuario entre com 1,5 ou 1.5 o programa ira entender.
        return if (ehNumero(num)) num.toDouble()
        else 0.0
    }
}