package com.example.pokemongen1lookup.data.api.models

import com.google.gson.annotations.SerializedName

data class PokemonGen1ResponseDTO (
    @SerializedName("results")val results: List<PokemonResultsDTO>
)