package com.banco.bancocomercio.model.service

import com.banco.bancocomercio.model.User
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    @GET("users")
    fun getUsers(): Call<List<User>>
}