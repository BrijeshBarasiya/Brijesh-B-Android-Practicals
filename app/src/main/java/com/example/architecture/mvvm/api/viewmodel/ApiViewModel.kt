package com.example.architecture.mvvm.api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.mvvm.api.model.ApiCallingModel
import com.example.intent_activity_fragment.BaseURL
import com.example.intent_activity_fragment.FailedMessage
import com.example.intent_activity_fragment.Result
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ApiViewModel : ViewModel() {

    // Variables
    private val mUserInfo = MutableLiveData<ApiCallingModel>()
    val userInfo: LiveData<ApiCallingModel?>
        get() = mUserInfo

    // Public Function
    fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            getDataFromApi(2)
        }
    }

    //Private getDataFromApi Functions
    private fun getDataFromApi(userID: Int) {
        val url = URL("$BaseURL/api/users/$userID")
        (url.openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            if (responseCode == 200) {
                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = it.readText()
                    val gson = Gson()
                    CoroutineScope(Dispatchers.Main).launch {
                        mUserInfo.value = gson.fromJson(response, ApiCallingModel::class.java)
                    }
                }
            } else {
                Log.d(Result, FailedMessage)
            }
        }
    }

}