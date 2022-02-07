package com.example.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.re_use_component.comm_spinner

class LinearLayoutDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout_demo)

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.spinner))
        comm_spinner.adapter = spinnerAdapter
    }

}