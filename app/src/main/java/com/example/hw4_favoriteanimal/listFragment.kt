package com.example.hw4_favoriteanimal

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_list.*
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

        view.frenchRatingText.text =viewModel.ratingList[0].toString()
        view.englishRatingText.text =viewModel.ratingList[1].toString()
        view.belgianRatingText.text =viewModel.ratingList[2].toString()
        view.germanRatingText.text =viewModel.ratingList[3].toString()
        view.chuiRatingText.text =viewModel.ratingList[4].toString()

        view.frenchButton.setOnClickListener {
            beginTrans()
            viewModel.position =0
        }
        view.englishButton.setOnClickListener {
            beginTrans()
            viewModel.position =1
        }
        view.belgianButton.setOnClickListener {
            beginTrans()
            viewModel.position =2
        }
        view.germanButton.setOnClickListener {
            beginTrans()
            viewModel.position =3
        }
        view.chichuahuaButton.setOnClickListener {
            beginTrans()
            viewModel.position =4
        }




        return view
    }
    companion object {
        @JvmStatic fun newInstance() =
            listFragment().apply {
            }
    }

    private fun beginTrans(){
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.second_Con, ratingFragment())
                .commit()
        }else {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.main_Con, ratingFragment.newInstance())
                .commit()
        }
    }

}