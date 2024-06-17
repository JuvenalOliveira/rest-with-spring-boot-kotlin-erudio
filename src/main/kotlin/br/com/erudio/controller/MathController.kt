package br.com.erudio.controller

import br.com.erudio.converters.NumberConverter
import br.com.erudio.exceptions.UnsupportedMathOperationException
import br.com.erudio.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController //criando um bean
class MathController {

    val contador: AtomicLong = AtomicLong()

    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"]) //Serve para mapear um end point
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?, //@PathVariable permite que o controller lide com requesição parametrizadas
        @PathVariable(value = "numberTwo") numberTwo: String? //Como variaveis.
    ): Double {
        if(!NumberConverter.ehNumero(numberOne) || !NumberConverter.ehNumero(numberTwo)) throw UnsupportedMathOperationException("Porfavor coloque um numero valido") //criando validação
        return math.sum(NumberConverter.converterDouble(numberOne), NumberConverter.converterDouble(numberTwo))
    }

        @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(
            @PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.ehNumero(numberOne) || !NumberConverter.ehNumero(numberTwo)) throw UnsupportedMathOperationException("Porfavor coloque um numero valido")
        return math.sub(NumberConverter.converterDouble(numberOne), NumberConverter.converterDouble(numberTwo))
    }

         @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
        fun divisao(
             @PathVariable(value = "numberOne") numberOne: String?,
             @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.ehNumero(numberOne) || !NumberConverter.ehNumero(numberTwo)) throw UnsupportedMathOperationException("Porfavor coloque um numero valido")
        return math.div(NumberConverter.converterDouble(numberOne), NumberConverter.converterDouble(numberTwo))
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
        fun mult(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if(!NumberConverter.ehNumero(numberOne) || !NumberConverter.ehNumero(numberTwo)) throw UnsupportedMathOperationException("Porfavor coloque um numero valido")
        return math.mult(NumberConverter.converterDouble(numberOne), NumberConverter.converterDouble(numberTwo))
    }

    @RequestMapping(value = ["/raiz/{numberOne}"])
        fun raiz(
        @PathVariable(value = "numberOne") numberOne: String?
    ): Double {
        if(!NumberConverter.ehNumero(numberOne)) throw UnsupportedMathOperationException("Porfavor coloque um numero valido")
        return math.raiz(NumberConverter.converterDouble(numberOne))
    }

}