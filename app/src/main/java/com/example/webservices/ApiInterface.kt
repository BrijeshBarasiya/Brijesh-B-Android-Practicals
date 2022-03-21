package com.example.webservices

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiInterface {

    @GET("/api/users?delay=3")
    fun allUserApi(): Call<UserDataValues>

    @POST("/api/users")
    fun createUser(@Body postData: PostDataClass): Call<PostResponseData>

    @PUT("/api/users/2")
    fun updateUser(@Body postData: PostDataClass): Call<PostResponseData>

    @DELETE("/api/users/2")
    fun deleteUser(): Call<Unit>

}