package com.example.recyclevier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_simple_list.simple_list_view

class SimpleList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_simple_list)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataClass.simpleListValues)
        simple_list_view.adapter = arrayAdapter
        simple_list_view.setOnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()
        }
    }

}