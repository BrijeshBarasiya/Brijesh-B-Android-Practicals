package com.example.architecture.mvvm.api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.architecture.mvvm.api.viewmodel.ApiViewModel
import com.example.architecture.mvvm.viewmodel.MVVMViewModel
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.FiveApiCallingUsingMvvmBinding
import com.example.basicofkotlin.databinding.FiveMvvmdemoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ApiCallingUsingMVVM : AppCompatActivity() {

    // Variables
    private lateinit var binding: FiveApiCallingUsingMvvmBinding
    val viewModel: ApiViewModel by viewModels()

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FiveApiCallingUsingMvvmBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.five_api_calling_using_mvvm)
        binding.fetchedData = viewModel
        binding.lifecycleOwner = this

        viewModel.userInfo.observe(this) {
            it?.let {
                Toast.makeText(applicationContext, "API Called Successfully", Toast.LENGTH_LONG).show()
            } ?: kotlin.run {
                Toast.makeText(applicationContext, "API Called Failed.", Toast.LENGTH_LONG).show()
            }
        }
    }

    // Function
    fun onCallApiClicked(view: View) {
        viewModel.fetchData()
    }

}