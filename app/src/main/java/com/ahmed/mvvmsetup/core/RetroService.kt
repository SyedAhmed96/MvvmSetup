package com.ahmed.mvvmsetup.core

import com.ahmed.mvvmsetup.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetroService {

    @GET("movielist.json")
    suspend fun getAllMovies(): Response<List<Movie>>

    companion object {
        var retrofitService: RetroService? = null

        fun getInstance(): RetroService {
            if(retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    retrofitService = retrofit.create(RetroService::class.java)
            }
            return retrofitService!!
        }
    }
}