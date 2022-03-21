package com.example.design_support_library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.SevenSimpleDrawerBinding

class SimpleDrawer : AppCompatActivity() {

    // VARIABLES
    private lateinit var binding: SevenSimpleDrawerBinding

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SevenSimpleDrawerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}