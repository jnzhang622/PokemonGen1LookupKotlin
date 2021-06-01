package com.example.pokemongen1lookup.data.api.models.singlepokemonmodels

import com.google.gson.annotations.SerializedName

data class SinglePokemonResponseDTO (
    @SerializedName("id")val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("types")val types: List<TypesDTO>,
    @SerializedName("sprites")val sprites: SpritesDTO,
    @SerializedName("abilities")val abilities: List<AbilitiesDTO>,
    @SerializedName("moves")val moves: List<MovesDTO>
        )