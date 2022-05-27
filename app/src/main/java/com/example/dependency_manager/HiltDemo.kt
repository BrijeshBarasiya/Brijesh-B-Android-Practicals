package com.example.dependency_manager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.ActivityHileDemoBinding
import com.example.dependency_manager.model.Mobile
import javax.inject.Inject

class HiltDemo : AppCompatActivity() {

    // Variables
    private lateinit var binding: ActivityHileDemoBinding

    @Inject
    lateinit var mobile: Mobile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHileDemoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}