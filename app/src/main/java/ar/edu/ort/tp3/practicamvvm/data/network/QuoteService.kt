package ar.edu.ort.tp3.practicamvvm.data.network

import ar.edu.ort.tp3.practicamvvm.core.RetrofitHelper
import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    //Hace todas las llamadas-> En esta clase se decide si llamo a la bd o retrofit.

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {//Con estro trabajo con corrutinas.
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
            //Si estaok barbaro -> Si no q traiga una lista vacia.
        }
    }
//Corrutinas hace q la llamada se ejecute en un hilo secundario.
}