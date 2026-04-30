package com.example.retrofittestproj

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface RetrofitApi {

    @GET("/posts")
    fun getAllPosts(): Call<List<Posts>>

    @POST("/auth/login")
    fun createPost(@Body login: Login): Call<Login>

    @POST("/auth/register")
    fun createUser(@Body user: User): Call<User>





}