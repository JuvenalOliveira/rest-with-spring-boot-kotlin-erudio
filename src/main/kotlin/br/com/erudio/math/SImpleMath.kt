package br.com.erudio.math
import java.lang.*
import java.util.*

import org.springframework.web.bind.annotation.PathVariable

class SimpleMath {
    fun sum(numberOne: Double, numberTwo: Double): Double{
        return numberOne + numberTwo
    }
    fun sub(numberOne: Double, numberTwo: Double): Double{
        return numberOne - numberTwo
    }
    fun mult(numberOne: Double, numberTwo: Double): Double{
        return numberOne * numberTwo
    }
    fun div(numberOne: Double, numberTwo: Double): Double{
        return numberOne / numberTwo
    }
    fun raiz(numberOne: Double): Double{
        return Math.sqrt(numberOne)
    }

}