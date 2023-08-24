package com.example.cnorrisp.data.network

import com.example.cnorrisp.data.model.JokeModelSimpleResponse
import com.example.cnorrisp.data.model.LongResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckApi {
    @GET("random")
    suspend fun getRandom(): Response<JokeModelSimpleResponse>

    @GET("random")
    suspend fun getCustom(@Query("name") name:String):Response<JokeModelSimpleResponse>

    @GET("search")
    suspend fun getList(@Query("query") query:String):Response<LongResponse>

}
