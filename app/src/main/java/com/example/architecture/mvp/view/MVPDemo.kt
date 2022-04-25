package com.example.architecture.mvp.view

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.mvp.model.MVPModel
import com.example.architecture.mvp.presenter.IMVPPresenterClass
import com.example.architecture.mvp.presenter.MVPPresenterClass
import com.example.basicofkotlin.databinding.FiveMvpDemoBinding

class MVPDemo : AppCompatActivity() {

    // Variables
    private lateinit var binding: FiveMvpDemoBinding
    private var presenterClass: IMVPPresenterClass = MVPPresenterClass()
    val viewModel: MVPModel by viewModels()

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FiveMvpDemoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenterClass.setValue(viewModel)
        binding.arithmeticParameters = viewModel
        binding.lifecycleOwner = this
        dismissKeyboard()
    }

    // Function
    fun arethmaticOperation(view: View) {
        if(binding.txtValue2.text.isNotEmpty()){
            when(view.id) {
                binding.btnAdd.id -> presenterClass.addition()
                binding.btnSub.id -> presenterClass.subtraction()
                binding.btnMul.id -> presenterClass.multiplication()
                binding.btnDiv.id -> {
                    val v2: Float = binding.txtValue2.text.toString().toFloat()
                    if(v2 == 0F) {
                        Toast.makeText(applicationContext, "Divided by Zero is Not Possible", Toast.LENGTH_SHORT).show()
                    } else {
                        presenterClass.division()
                    }
                }
            }
            binding.txtValue2.text.clear()
        } else {
            Toast.makeText(applicationContext, "Enter Second Parameter.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun dismissKeyboard() {
        binding.layoutMvpDemo.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }
    }

}