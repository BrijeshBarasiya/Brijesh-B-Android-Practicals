package com.example.architecture

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.mvc.controller.MVCController
import com.example.architecture.mvp.view.MVPDemo
import com.example.architecture.mvvm.api.view.ApiCallingUsingMVVM
import com.example.architecture.mvvm.view.MVVMDemo
import com.example.basicofkotlin.databinding.FiveAndroidArchitectureBinding
import com.example.binding_adapter.BindingAdapterDemo
import com.example.coroutine.CoRoutineDemo
import com.example.view_model_factory.ViewModelFactoryDemo

class AndroidArchitecture : AppCompatActivity(), View.OnClickListener {

    // Variables
    private lateinit var binding: FiveAndroidArchitectureBinding

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FiveAndroidArchitectureBinding.inflate(layoutInflater)
        val view = binding.root
        binding.onClicked = this
        setContentView(view)
    }

    // Function
    override fun onClick(view: View) {
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
            binding.btnApiCallingUsingMvvm.id -> {
                Intent(this, ApiCallingUsingMVVM::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnBindingAdapter.id -> {
                Intent(this, BindingAdapterDemo::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnViewModelFactory.id -> {
                Intent(this, ViewModelFactoryDemo::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnCoRoutine.id -> {
                Intent(this, CoRoutineDemo::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

}