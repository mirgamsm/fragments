package com.example.hw4_favoriteanimal

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_Con, listFragment())
            .commit()

        if(resources.configuration.orientation ==Configuration.ORIENTATION_LANDSCAPE){
            supportFragmentManager.beginTransaction()
                .replace(R.id.second_Con, ratingFragment())
                .commit()

        }
    }
}