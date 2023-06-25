package ar.edu.ort.tp3.practicamvvm.data

import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteModel
import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteProvider
import ar.edu.ort.tp3.practicamvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}