package com.example.webservices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.FourManualJsonDataparsingBinding
import com.example.intent_activity_fragment.BaseURL
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class ManualJsonDataParsing : AppCompatActivity() {

    //Variables
    private lateinit var binding: FourManualJsonDataparsingBinding

    //Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourManualJsonDataparsingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //GetData Button Click Event
        binding.btnGetData.setOnClickListener {
            Thread {
                getManualData()
            }.start()
        }
    }

    //Other Functions
    private fun getManualData() {
        val client = OkHttpClient()
        val url = URL("$BaseURL/api/users/2")
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread{
                    val text = "Not Able to Fetch User Data"
                    binding.txtData.text = text
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseStatus = response.body()?.string()
                val data = JSONObject(responseStatus).getJSONObject("data")
                val text = "Name: ${data.get("first_name")}  ${data.get("last_name")}\nEmail: ${data.get("email")}"
                runOnUiThread {
                    binding.txtData.text = text
                }
            }
        })
    }

}