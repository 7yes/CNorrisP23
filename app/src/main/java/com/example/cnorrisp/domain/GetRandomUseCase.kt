package com.example.cnorrisp.domain

import com.example.cnorrisp.data.network.ChuckService
import javax.inject.Inject

class GetRandomUseCase @Inject constructor(private val service: ChuckService) {

    suspend fun getRandom(): String {
        return service.getRandom()
    }
}
