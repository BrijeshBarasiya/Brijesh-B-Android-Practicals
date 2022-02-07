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
        var arrayList = ArrayList<String>()
        arrayList.add("Item 1")
        arrayList.add("Item 2")
        arrayList.add("Item 3")
        arrayList.add("Item 4")
        arrayList.add("Item 5")
        arrayList.add("Item 6")
        arrayList.add("Item 7")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        //val arrayAdapter = ArrayAdapter(this, R.layout.listview_item, R.id.lstv_heading, arrayList)
        simple_list_view.adapter = arrayAdapter
        simple_list_view.setOnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()
        }
    }

}