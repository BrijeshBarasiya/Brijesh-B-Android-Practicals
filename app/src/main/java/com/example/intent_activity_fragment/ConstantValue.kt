package com.example.intent_activity_fragment

import com.example.webservices.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BaseURL = "https://reqres.in"
const val UserID = "UserID"
const val Result = "Result"
const val FailedMessage ="Failed to get Data"
val retrofitBuilder: ApiInterface by lazy {
    return@lazy Retrofit.Builder().baseUrl(BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)
}

class ConstantValue {

    object ExplicitIntentDataKeys {
        const val nameValue = "nameValue"
        const val imageValue = "imageValue"
        const val httpURL = "https://www.google.co.in"
    }

}