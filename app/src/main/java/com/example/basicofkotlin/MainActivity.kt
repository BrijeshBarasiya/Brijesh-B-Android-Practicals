package com.example.basicofkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.layoutRecyclerview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var exerciseList = mutableListOf("Chapter: 3(A) Ui Widgets")
        layoutRecyclerview.adapter = RecyclerviewAdapter(exerciseList)
        layoutRecyclerview.layoutManager = LinearLayoutManager(this)
    }

}