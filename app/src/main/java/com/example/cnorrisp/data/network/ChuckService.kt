package com.example.cnorrisp.data.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChuckService @Inject constructor(private val api: ChuckApi) {

    suspend fun getRandom(): String {
        return withContext(Dispatchers.IO) {
            val response = api.getRandom()
            val body = response.body()
            val joke = body?.joke ?: ""
            joke
        }
    }

    suspend fun getCustom(name: String): String {
        return withContext(Dispatchers.IO) {
            val response = api.getCustom(name)
            val joke = response.body()?.joke
            Log.d("TAG", "getCustom: service $joke ")
            joke ?: "Service Error"
        }
    }
}
