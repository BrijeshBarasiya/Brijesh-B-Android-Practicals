package com.example.architecture.mvvm.view

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.architecture.mvvm.viewmodel.MVVMViewModel
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.FiveMvvmdemoBinding

class MVVMDemo : AppCompatActivity() {

    // Variables
    private lateinit var binding: FiveMvvmdemoBinding
    val viewModel: MVVMViewModel by viewModels()

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FiveMvvmdemoBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.five_mvvmdemo)
        binding.arithmeticParameters = viewModel
        binding.lifecycleOwner = this
        dismissKeyboard()
    }

    // Functions
    fun arethmaticOperation(view: View) {
        val button: Button = view as Button
        if(viewModel.arithmeticOperation(button.text.toString()))
            binding.txtValue2.text.clear()
        else
            Toast.makeText(applicationContext, this.getString(R.string.five_enter_value), Toast.LENGTH_LONG).show()
    }

    private fun dismissKeyboard() {
        binding.layoutMvvmDemo.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        }
    }

}

