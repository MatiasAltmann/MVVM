package ar.edu.ort.tp3.practicamvvm.data.Model

class QuoteProvider {
    //Uso esto para crear obtetos de Quote model (Desp lo remplazo x retrofit)
    companion object { //Companion ->Clase estatica
        var quotes: List<QuoteModel> = emptyList()
    }
    /*
    La incializo vacia.
    Llamo al repositorio -> Llama al service -> El service llama al api cliente
    -> Recupera el listado de la response del endpoint -> Lo devuelve al service -> Lo devuelve al repositoy
    -> Y el repositorio le devuelve al provider la response.
     */

}