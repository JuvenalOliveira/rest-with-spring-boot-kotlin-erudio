package br.com.erudio.converters

object NumberConverter {
    fun ehNumero(numero: String?): Boolean{
        if (numero.isNullOrBlank()) return false
        val num = numero.replace(",".toRegex(),".")
        return num.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
    fun converterDouble(numero: String?): Double{
        if (numero.isNullOrBlank()) return 0.0 //caso numero for null retornara 0
        val num = numero.replace(",".toRegex(),".") //caso usuario entre com 1,5 ou 1.5 o programa ira entender.
        return if (ehNumero(num)) num.toDouble()
        else 0.0
    }
}