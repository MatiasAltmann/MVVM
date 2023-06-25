package ar.edu.ort.tp3.practicamvvm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ar.edu.ort.tp3.practicamvvm.R
import ar.edu.ort.tp3.practicamvvm.ViewModel.QuoteViewModel


class FragmentHome : Fragment() {
    lateinit var viewF:View
    lateinit var tvQuote:TextView
    lateinit var tvAuthor:TextView
    lateinit var iconoCarga:ProgressBar
    lateinit var quoteViewModel:QuoteViewModel
    lateinit var containerView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewF = inflater.inflate(R.layout.fragment_home, container, false)
        tvQuote = viewF.findViewById(R.id.tvQuote)
        tvAuthor = viewF.findViewById(R.id.tvAuthor)
        containerView = viewF.findViewById(R.id.viewContainer)
        quoteViewModel = ViewModelProvider(requireActivity()).get(QuoteViewModel::class.java)
        iconoCarga = viewF.findViewById(R.id.progress)
        quoteViewModel.onCreate()


        quoteViewModel.quoteModel.observe(viewLifecycleOwner, Observer { currentQuote ->
            tvQuote.text = currentQuote.quote
            tvAuthor.text = currentQuote.author
        })
        quoteViewModel.isLoading.observe(viewLifecycleOwner, Observer{
            iconoCarga.isVisible = it //El it, es el boolean q contiene el liveData
        })


        containerView.setOnClickListener { quoteViewModel.randomQuote() }



        return viewF
    }


}