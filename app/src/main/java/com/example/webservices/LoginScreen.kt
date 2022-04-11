package com.example.webservices

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.FourLoginScreenBinding
import com.example.intent_activity_fragment.BaseURL
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class LoginScreen : AppCompatActivity() {

    // Variables
    private lateinit var binding: FourLoginScreenBinding

    //Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourLoginScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Submit Button Click Event
        binding.btnSubmit.setOnClickListener {
            if (validation(binding.txtUsername)) {
                binding.progressBar.visibility = View.VISIBLE
                Thread {
                    try {
                        val result = httpPostRequest(binding.txtUsername.text.toString(), binding.txtPassword.text.toString())
                        runOnUiThread {
                            if (result) {
                                val intent = Intent(this, UserList::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this@LoginScreen, "Logged In Failed", Toast.LENGTH_LONG).show()
                            }
                        }
                        binding.progressBar.visibility = View.INVISIBLE
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                }.start()
            } else {
                Toast.makeText(applicationContext, "Enter Proper Input", Toast.LENGTH_LONG).show()
            }
        }

        //Manual Parsing Button Click Event
        binding.btnManualParsing.setOnClickListener {
            Intent(this, ManualJsonDataParsing::class.java).apply {
                startActivity(this)
            }
        }
    }

    //Functions
    private fun validation(validation: EditText): Boolean {
        val text = validation.text.toString()
        return if(text.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            validation.requestFocus()
            validation.error = "Enter Proper Email Address"
            false
        } else {
            true
        }
    }

    private fun httpPostRequest(username: String, password: String): Boolean {
        val credential = JSONObject()
        credential.put("email", username)
        credential.put("password", password)
        val url = URL("$BaseURL/api/login")
        (url.openConnection() as HttpURLConnection).apply {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            val output = OutputStreamWriter(outputStream)
            output.write(credential.toString())
            output.flush()
            return (responseCode == 200)
        }
    }

}