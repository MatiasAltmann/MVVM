package ar.edu.ort.tp3.practicamvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.edu.ort.tp3.practicamvvm.Model.QuoteModel
import ar.edu.ort.tp3.practicamvvm.Model.QuoteProvider

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

        fun randomQuote() {
            val currentQuote = QuoteProvider.random()
            quoteModel.postValue(currentQuote)
            //PostValue le asigna el valor -> Para actualizarlo.
            //Con esto le avisa a la activity/fragment del cambio
        }


}