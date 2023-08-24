package com.example.cnorrisp.data.network

import android.util.Log
import com.example.cnorrisp.core.isNull
import com.example.cnorrisp.ui.model.JokeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChuckService @Inject constructor(private val api: ChuckApi) {

    suspend fun getRandom(): JokeItem {
        return withContext(Dispatchers.IO) {
            val response = api.getRandom()
            val body = response.body()
            JokeItem(body?.id ?: "aaa",body?.joke ?: "no hubo")
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

    suspend fun getList(query: String): List<String> {
        return withContext((Dispatchers.IO)) {
            val jokes = mutableListOf<String>()
            val response = api.getList(query)
            val body = response.body()
            body?.result?.forEach {
                jokes.add(it.joke)
            }
            Log.d("TAG", "getList: agregue $jokes ")
            jokes
        }
    }
}
