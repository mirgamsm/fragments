package com.example.hw4_favoriteanimal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_rating.view.*


class ratingFragment : Fragment() {
    lateinit var viewModel: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rating, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        viewModel.ratingList[viewModel.position] =view.ratingBar.rating
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ratingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}