package com.example.hw4_favoriteanimal

import android.content.res.Configuration
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
        var imageID =when(viewModel.position){
            0 -> R.drawable.french_bulldog
            1 -> R.drawable.english_bulldog
            2 -> R.drawable.belgian_malinois
            3 -> R.drawable.german_shepherd
            else -> R.drawable.chihuahuas
        }
        var nameString =when(viewModel.position){
            0 -> R.string.FRENCH
            1 -> R.string.ENGLISH
            2 -> R.string.BELGIAN
            3 -> R.string.GERMAN
            else -> R.string.CHIU
        }
        view.ratingBar.rating = viewModel.ratingList[viewModel.position]
        view.nameText.text =getString(nameString)
        view.mainImage.setImageResource(imageID)
        view.setRatingButton.setOnClickListener {

            viewModel.ratingList[viewModel.position] =view.ratingBar.rating
            beginTrans()

        }
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