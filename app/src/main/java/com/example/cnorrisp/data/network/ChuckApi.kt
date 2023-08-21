package com.example.cnorrisp.data.network

import com.example.cnorrisp.data.model.ChuckSimpleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChuckApi {
    @GET("random")
    suspend fun getRandom(): Response<ChuckSimpleResponse>
}
