package com.example.architecture.mvc.controller

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture.mvc.model.MVCModel
import com.example.basicofkotlin.databinding.FiveMvcDemoBinding

class MVCController : AppCompatActivity() {

    // Variables
    private lateinit var binding: FiveMvcDemoBinding
    private lateinit var mvcModel: MVCModel

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FiveMvcDemoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dismissKeyboard()
    }

    // Function
    fun arethmaticOperation(view: View) {
        if(binding.txtValue2.text.isNotEmpty()){
            val v1: Float = binding.txtValue1.text.toString().toFloat()
            val v2: Float = binding.txtValue2.text.toString().toFloat()
            mvcModel = MVCModel(v1, v2)
            when(view.id) {
                binding.btnAdd.id -> binding.txtValue1.text = addition(mvcModel).toString()
                binding.btnSub.id -> binding.txtValue1.text = subtraction(mvcModel).toString()
                binding.btnMul.id -> binding.txtValue1.text = multiplication(mvcModel).toString()
                binding.btnDiv.id -> {
                    if(v2 == 0F) {
                        Toast.makeText(applicationContext, "Divided by Zero is Not Possible", Toast.LENGTH_SHORT).show()
                    } else {
                        binding.txtValue1.text = division(mvcModel).toString()
                    }
                }
            }
            binding.txtValue2.text.clear()
        } else {
            Toast.makeText(applicationContext, "Enter Value Two.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addition(value: MVCModel): Float  {
        return (value.value1 + value.value2)
    }

    private fun subtraction(value: MVCModel): Float {
        return (value.value1 - value.value2)
    }

    private fun multiplication(value: MVCModel): Float {
        return (value.value1 * value.value2)
    }

    private fun division(value: MVCModel): Float {
        return (value.value1 / value.value2)
    }

    private fun dismissKeyboard() {
        binding.layoutMvcDemo.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }

        }
    }

}