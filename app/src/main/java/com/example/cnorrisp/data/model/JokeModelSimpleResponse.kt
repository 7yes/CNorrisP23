package com.example.cnorrisp.data.model

import com.google.gson.annotations.SerializedName

data class JokeModelSimpleResponse(
    @SerializedName("value") val joke: String,
    @SerializedName("id") val id: String
)
