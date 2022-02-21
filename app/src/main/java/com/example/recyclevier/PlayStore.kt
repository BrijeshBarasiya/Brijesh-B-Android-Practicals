package com.example.recyclevier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_play_store.playstore_recyclerview

class PlayStore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_play_store)
        val adapter = PlayStoreAdapter(DataClass.playStoreValues)
        playstore_recyclerview.adapter = adapter
        
    }

}