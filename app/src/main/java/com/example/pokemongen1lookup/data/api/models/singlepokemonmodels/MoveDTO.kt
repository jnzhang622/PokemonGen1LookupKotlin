package com.example.pokemongen1lookup.data.api.models.singlepokemonmodels

import com.google.gson.annotations.SerializedName

data class MoveDTO (
    @SerializedName("name")val name: String,
    @SerializedName("url")val url: String
)