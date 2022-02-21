package com.example.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_b_reuse_component.comm_spinner

class LinearLayoutDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_b_linear_layout)

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.spinner))
        comm_spinner.adapter = spinnerAdapter
    }

}