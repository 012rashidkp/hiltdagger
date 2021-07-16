package com.example.hiltdagger.Network

import com.example.hiltdagger.Model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServieInstance {
    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<RecyclerList>
}