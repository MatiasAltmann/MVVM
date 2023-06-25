package ar.edu.ort.tp3.practicamvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.tp3.practicamvvm.Domain.GetQuotesUseCase
import ar.edu.ort.tp3.practicamvvm.Domain.GetRandomQuoteUseCase
import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteModel
import ar.edu.ort.tp3.practicamvvm.data.Model.QuoteProvider
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>() //Es el q mustra/oclta el progressBar
    var getQuotesUseCase = GetQuotesUseCase() //Trae todos (Pero no random)
    var getRandomQuotesUseCase = GetRandomQuoteUseCase()
    fun onCreate() {
        //Llamamos a nuestro caso de uso para q nos devuelva todas las quotes.
        //El viewModel -> Tiene viewModelScope para trabajr con corrutinas.

        viewModelScope.launch {
            isLoading.postValue(true)

            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0]) //Para q me cargue la primera directamente.
                isLoading.postValue(false)
            }
        }
    }
    // el result ->Llama al caso de uso
    //El caso de uso al repo pertinente.
    //Ahora lo haria en la api -> Llama al servicio
    //El servicio llama a retrofit para devolver los quotes.

        fun randomQuote() { //Para traerme 1 solo random.
          //  val currentQuote = QuoteProvider.random()
         //   quoteModel.postValue(currentQuote)
            //PostValue le asigna el valor -> Para actualizarlo.
            //Con esto le avisa a la activity/fragment del cambio

            isLoading.postValue(true)
            val quote = getRandomQuotesUseCase()
            if(quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)


        }




}