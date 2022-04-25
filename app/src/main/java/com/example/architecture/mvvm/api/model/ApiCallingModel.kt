package com.example.architecture.mvvm.api.model

import com.google.gson.annotations.SerializedName

data class ApiCallingModel(
    val data: ApiData,
    val support: ApiSupport
)

data class ApiData(
    val avatar: String,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
)

data class ApiSupport(
    val text: String,
    val url: String
)