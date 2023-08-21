package com.example.cnorrisp.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChuckService @Inject constructor(private val api: ChuckApi) {

    suspend fun getRandom(): String {
        return withContext(Dispatchers.IO){
            val response = api.getRandom()
            val body = response.body()
            val joke = body?.joke ?: ""
            joke
        }
    }
}
