package com.example.intent_activity_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.ThreeDIntentBinding

class IntentClass : AppCompatActivity() {

    private lateinit var binding: ThreeDIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThreeDIntentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.intentImplicit.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ConstantValue.ExplicitIntentDataKeys.httpURL))
            startActivity(intent)
        }
        binding.intentExplicit.setOnClickListener {
            if(!binding.intentInput.text.isEmpty()) {
                val intent = Intent(this, ExplicitIntent::class.java)
                intent.putExtra(ConstantValue.ExplicitIntentDataKeys.nameValue, binding.intentInput.text.toString())
                intent.putExtra(ConstantValue.ExplicitIntentDataKeys.imageValue, R.drawable.ic_call)
                startActivity(intent)
            } else
                Toast.makeText(applicationContext, resources.getString(R.string.three_d_enter_your_name), Toast.LENGTH_LONG).show()
        }
    }

}