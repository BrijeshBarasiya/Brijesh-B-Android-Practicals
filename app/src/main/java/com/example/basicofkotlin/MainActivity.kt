package com.example.basicofkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.one_activity_main.layout_recyclerview


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_activity_main)
        AppCenter.start(
            application, "57297735-c216-42eb-871c-793580ee6593",
            Analytics::class.java, Crashes::class.java
        )
        var exerciseList = mutableListOf("Chapter: 3(A) Ui-Widgets")
        exerciseList.add("Chapter: 3(B) Ui-Widgets")
        exerciseList.add("Chapter: 3(C) RecyclerView ")
        exerciseList.add("Chapter: 3(D) Intent, Activity & Fragment")
        exerciseList.add("Chapter: 3(E) Other Important Layout")
        exerciseList.add("Chapter: 4 Web Services")
        exerciseList.add("Chapter: 5 Android Architecture")
        exerciseList.add("Chapter: 6 Permission Model")
        exerciseList.add("Fragment Data Passing")
        exerciseList.add("Chapter: 7 Design Support Library")
        layout_recyclerview.adapter = RecyclerviewAdapter(exerciseList)
        layout_recyclerview.layoutManager = LinearLayoutManager(this)
    }

}