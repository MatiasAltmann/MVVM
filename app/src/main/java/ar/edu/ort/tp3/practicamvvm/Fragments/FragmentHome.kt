package ar.edu.ort.tp3.practicamvvm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ar.edu.ort.tp3.practicamvvm.Model.QuoteModel
import ar.edu.ort.tp3.practicamvvm.R
import ar.edu.ort.tp3.practicamvvm.ViewModel.QuoteViewModel


class FragmentHome : Fragment() {
    lateinit var viewF:View
    lateinit var tvQuote:TextView
    lateinit var tvAuthor:TextView
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

        quoteViewModel.quoteModel.observe(viewLifecycleOwner, Observer { currentQuote ->
            tvQuote.text = currentQuote.quote
            tvAuthor.text = currentQuote.author
        })

        containerView.setOnClickListener { quoteViewModel.randomQuote() }



        return viewF
    }


}