package com.example.basicofkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.one_activity_main.layout_recyclerview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_activity_main)
        var exerciseList = mutableListOf("Chapter: 3(A) Ui-Widgets")
        exerciseList.add("Chapter: 3(B) Ui-Widgets")
        exerciseList.add("Chapter: 3(C) RecyclerView ")
        layout_recyclerview.adapter = RecyclerviewAdapter(exerciseList)
        layout_recyclerview.layoutManager = LinearLayoutManager(this)
    }

}