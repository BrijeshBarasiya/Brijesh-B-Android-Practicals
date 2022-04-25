package com.example.view_model_factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.FiveViewModelFactoryDemoBinding

class ViewModelFactoryDemo: AppCompatActivity() {

    private lateinit var binding: FiveViewModelFactoryDemoBinding
    lateinit var modelFactory: ModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.five_view_model_factory_demo)
        binding = FiveViewModelFactoryDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf(this.getString(R.string.app_name), this.getString(R.string.five_coroutine))
        modelFactory = ViewModelProvider(this, ViewModelFactory(list))[ModelFactory::class.java]
        printValues()
        dismissKeyboard()
    }

    private fun dismissKeyboard() {
        binding.layoutViewModelFactory.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }
    }

    private fun printValues() {
        binding.lblDisplayResult.text = modelFactory.list.toString()
    }

    fun onAddNewButtonClicked(view: View) {
        if (binding.txtNewData.text.toString().isNotEmpty()) {
            modelFactory.appendItem(binding.txtNewData.text.toString())
            binding.txtNewData.text?.clear()
            printValues()
        } else
            Toast.makeText(applicationContext, this.getString(R.string.enter_text), Toast.LENGTH_SHORT).show()
    }

}