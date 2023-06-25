package ar.edu.ort.tp3.practicamvvm.Domain

import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteModel
import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteProvider
import ar.edu.ort.tp3.practicamvvm.data.QuoteRepository

class GetRandomQuoteUseCase {

   // private val repository = QuoteRepository()

    operator fun invoke():QuoteModel?{
       val quotes = QuoteProvider.quotes //Esto es xq tomo la lista q ya me guarde en memoria.
        if(!quotes.isNullOrEmpty()) {     //X ESO NO APLICO CORRUTINAS DE NUEVO.
            val randonNumber = (0..quotes.size - 1).random()
            return quotes[randonNumber]
        }
        return null
    }

}