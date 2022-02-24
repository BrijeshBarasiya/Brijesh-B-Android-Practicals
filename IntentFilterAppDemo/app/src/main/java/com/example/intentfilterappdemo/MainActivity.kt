package com.example.intentfilterappdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    lateinit var image: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<EditText>(R.id.hello_text)
        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { getImage ->
            val data: Intent? = getImage.data
            if (data?.data != null) {
                image = data.data!!
            }
        }
        Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
            launcher.launch(this)
        }
        findViewById<Button>(R.id.hello_button).setOnClickListener {
            Intent().apply {
                if(!text.text.toString().isEmpty()) {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, text.text.toString())
                    putExtra(Intent.EXTRA_STREAM, image)
                    type = "text/plain"
                    setPackage("com.example.basicofkotlin")
                    startActivity(this)
                } else
                    Toast.makeText(applicationContext, "Enter Text...", Toast.LENGTH_LONG).show()

            }
        }
    }

}