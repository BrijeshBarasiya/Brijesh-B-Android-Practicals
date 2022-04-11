package com.example.webservices

 import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.FourSingleUserBinding
import com.example.intent_activity_fragment.BaseURL
import com.example.intent_activity_fragment.UserID
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SingleUser : AppCompatActivity() {

    //Variables
    private lateinit var binding: FourSingleUserBinding

    //Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourSingleUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Thread {
            getSingleUser(intent.getIntExtra(UserID,1))
        }.start()
    }

    //Other Functions
    private fun getSingleUser(userID: Int) {
        val url = URL("$BaseURL/api/users/$userID")
        (url.openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            if (responseCode == 200) {
                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = it.readText()
                    val gson = Gson()
                    val userData = gson.fromJson(response, User::class.java)
                    val fullName = "${userData.data.firstName} ${userData.data.lastName}"
                    binding.userProfileEmail.text = userData.data.email
                    binding.userProfileName.text = fullName
                    runOnUiThread{Picasso.get().load(userData.data.avatar).into(binding.userProfileImage)}
                }
            } else {
                runOnUiThread {
                    Toast.makeText(applicationContext,"Sorry User Not Found",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}