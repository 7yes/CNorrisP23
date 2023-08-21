package com.example.cnorrisp.data.model

import com.google.gson.annotations.SerializedName

data class ChuckSimpleResponse(
    @SerializedName("value") val joke: String
)
