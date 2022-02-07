package com.example.basicofkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.layout_recyclerview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var exerciseList = mutableListOf("Chapter: 3(A) Ui-Widgets", "Chapter: 3(B) Ui-Widgets")
        layout_recyclerview.adapter = RecyclerviewAdapter(exerciseList)
        layout_recyclerview.layoutManager = LinearLayoutManager(this)
    }

}