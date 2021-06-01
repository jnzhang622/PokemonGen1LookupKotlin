package com.example.pokemongen1lookup.repos

import com.example.pokemongen1lookup.data.api.models.PokemonGen1ResponseDTO
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import com.example.pokemongen1lookup.data.api.network.PokemonAPIManager
import io.reactivex.Single
import retrofit2.Response

class PokemonRepo {

    suspend fun getGen1Pokemon() : Response<PokemonGen1ResponseDTO> {
        return PokemonAPIManager().getGen1Pokemon(
            "151"
        )
    }

    suspend fun getSinglePokemon(name: String) : Response<SinglePokemonResponseDTO> {
        return PokemonAPIManager().getSinglePokemon(
            name
        )
    }

}