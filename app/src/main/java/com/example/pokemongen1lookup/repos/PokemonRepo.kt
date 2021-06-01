package com.example.pokemongen1lookup.repos

import com.example.pokemongen1lookup.data.api.models.PokemonGen1ResponseDTO
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import com.example.pokemongen1lookup.data.api.network.PokemonAPIManager
import io.reactivex.Single

class PokemonRepo {

    fun getGen1Pokemon() : Single<PokemonGen1ResponseDTO> {
        return PokemonAPIManager().getGen1Pokemon(
            "151"
        )
    }

    fun getSinglePokemon(name: String) : Single<SinglePokemonResponseDTO> {
        return PokemonAPIManager().getSinglePokemon(
            name
        )
    }

}