package com.example.hw4_favoriteanimal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_list.view.*


class listFragment : Fragment() {

    lateinit var viewModel: MyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        viewModel=ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

            view.belgianButton.setOnClickListener {
                beginTrans()
                viewModel.position =0
            }
            view.chichuahuaButton.setOnClickListener {
                beginTrans()
                viewModel.position =1
            }
            view.germanButton.setOnClickListener {
                beginTrans()
                viewModel.position =2
            }
            view.englishButton.setOnClickListener {
                beginTrans()
                viewModel.position =3
            }
            view.frenchButton.setOnClickListener {
                beginTrans()
                viewModel.position =4
            }

        return view
    }

    private fun beginTrans(){
        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.main_Con, ratingFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

}