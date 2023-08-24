package com.example.cnorrisp.domain

import com.example.cnorrisp.data.network.ChuckService
import com.example.cnorrisp.ui.model.JokeItem
import javax.inject.Inject

class GetRandomUseCase @Inject constructor(private val service: ChuckService) {

    suspend fun getRandom(): JokeItem {
        return service.getRandom()
    }
}
