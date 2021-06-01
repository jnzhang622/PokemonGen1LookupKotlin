package com.example.pokemongen1lookup.data.api.models

import com.google.gson.annotations.SerializedName

data class PokemonResultsDTO (
    @SerializedName("name")val name: String,
    @SerializedName("url")val url: String
)