package com.example.cnorrisp.data.network

import com.example.cnorrisp.data.model.ChuckSimpleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckApi {
    @GET("random")
    suspend fun getRandom(): Response<ChuckSimpleResponse>

    @GET("random")
    suspend fun getCustom(@Query("name") name:String):Response<ChuckSimpleResponse>

}
