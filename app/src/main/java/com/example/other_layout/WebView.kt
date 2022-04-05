package com.example.other_layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.FourEWebViewBinding

class WebView : AppCompatActivity() {

    // Variables
    private lateinit var binding: FourEWebViewBinding

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourEWebViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.webview.loadUrl("https://www.google.co.in/")
        binding.toggleButton.addOnButtonCheckedListener { _, checkedId, _ ->
            when(checkedId) {
                binding.pdfButton.id -> {
                    val url = "http://www.africau.edu/images/default/sample.pdf"
                    binding.webview.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
                }
                binding.htmlButton.id -> {
                    binding.webview.loadUrl("file:///android_asset/demoHTML.html")
                }
                binding.webButton.id -> {
                    binding.webview.loadUrl("https://www.google.co.in/")
                }
            }
        }
    }

}