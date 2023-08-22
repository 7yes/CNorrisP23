package com.example.cnorrisp.domain

import com.example.cnorrisp.data.network.ChuckService
import javax.inject.Inject

class GetQueryUseCase @Inject constructor(private val service: ChuckService) {

    suspend fun getList(query:String):List<String>{
        return service.getList(query)
    }
}
