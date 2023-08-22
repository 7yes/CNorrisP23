package com.example.cnorrisp.domain

import com.example.cnorrisp.data.network.ChuckService
import javax.inject.Inject

class GetCustomUseCase @Inject constructor(private val service: ChuckService) {
    suspend fun getCustom(name: String): String {
        return service.getCustom(name)
    }
}
