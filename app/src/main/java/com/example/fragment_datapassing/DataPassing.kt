package com.example.fragment_datapassing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.OtherDataPassingBinding

class DataPassing : AppCompatActivity() {

    // VARIABLES
    private lateinit var binding: OtherDataPassingBinding

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OtherDataPassingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}