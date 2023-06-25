package ar.edu.ort.tp3.practicamvvm.data.network

import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
    //Suspend -> Corrutinas.
}