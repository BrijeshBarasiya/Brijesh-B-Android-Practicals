package com.example.intent_activity_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.ThreeDPractical2Binding

class Practical2 : AppCompatActivity() {

    private lateinit var binding: ThreeDPractical2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThreeDPractical2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val nav = Navigation.findNavController(this, R.id.jetpack_fragment)
        binding.jetpackBottomNavigation.setupWithNavController(nav)
    }

}