package ar.edu.ort.tp3.practicamvvm.Domain

import ar.edu.ort.tp3.practicamvvm.data.QuoteRepository

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke() = repository.getAllQuotes()

    //Con el invoke, cuando llamo a la clase, directo me retorna
    //el método.

}