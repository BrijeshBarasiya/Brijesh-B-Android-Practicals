package com.example.intent_activity_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.ThreeDIntentFilterBinding

class IntentFilter : AppCompatActivity() {

    private lateinit var binding: ThreeDIntentFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThreeDIntentFilterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.intentFilterGettext.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        binding.intentFilterImage.setImageURI(intent.extras?.get(Intent.EXTRA_STREAM) as Uri)
    }

}
