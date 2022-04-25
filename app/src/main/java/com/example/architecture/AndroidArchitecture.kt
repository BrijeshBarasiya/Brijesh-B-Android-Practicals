package com.example.architecture

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.mvc.controller.MVCController
import com.example.architecture.mvp.view.MVPDemo
import com.example.architecture.mvvm.view.MVVMDemo
import com.example.basicofkotlin.databinding.FiveAndroidArchitectureBinding

class AndroidArchitecture : AppCompatActivity() {

    // Variables
    private lateinit var binding: FiveAndroidArchitectureBinding

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FiveAndroidArchitectureBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    // Function
    fun onSelectorClicked(view: View) {
        when(view.id) {
            binding.btnMvc.id -> {
                Intent(this, MVCController::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnMvp.id -> {
                Intent(this, MVPDemo::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnMvvm.id -> {
                Intent(this, MVVMDemo::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

}