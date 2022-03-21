package com.example.design_support_library

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.SevenCoordinatorLayoutBinding

class CoordinatorLayout : AppCompatActivity() {

    // VARIABLES
    private lateinit var binding: SevenCoordinatorLayoutBinding

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SevenCoordinatorLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.screenSmallToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.screenSmallToolbar.setNavigationOnClickListener {
            finish()
        }
        binding.floatingButton.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

}