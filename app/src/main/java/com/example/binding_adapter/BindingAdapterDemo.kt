package com.example.binding_adapter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.lifecycle.MutableLiveData
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.FiveBindingAdapterDemoBinding

class BindingAdapterDemo : AppCompatActivity() {

    // Variables
    private lateinit var binding: FiveBindingAdapterDemoBinding
    var bindingData = MutableLiveData("Hello")
    var inverseValue1 = MutableLiveData(0F)

    //Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.five_binding_adapter_demo)
        binding.bindingData = this
        binding.lifecycleOwner = this
    }

    companion object {
        @BindingAdapter("custom")
        @JvmStatic()
        fun setCustomText(view: TextView, item: String) {
            val text = "Binding Text $item"
            view.text = text
        }
    }

    @InverseMethod("stringToFloat")
    fun floatToString(value: Float?): String? = value?.toString()

    fun stringToFloat(value: String?): Float? = value?.toFloat()

}