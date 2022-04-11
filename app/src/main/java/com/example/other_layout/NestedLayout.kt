package com.example.other_layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.FourENestedLayoutBinding

class NestedLayout : AppCompatActivity() {

    // Variables
    private lateinit var binding: FourENestedLayoutBinding

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourENestedLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}