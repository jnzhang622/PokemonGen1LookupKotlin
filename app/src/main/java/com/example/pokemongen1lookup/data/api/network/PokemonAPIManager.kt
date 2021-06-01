package com.example.pokemongen1lookup.data.api.network

import com.example.pokemongen1lookup.data.api.models.PokemonGen1ResponseDTO
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class PokemonAPIManager {
    private val service: PokemonApiService
    private val retrofit = RetrofitService.providesRetrofitService()

    init {
        service = retrofit.create(PokemonApiService::class.java)
    }

    suspend fun getSinglePokemon(name: String): Response<SinglePokemonResponseDTO> {
        return service.getSinglePokemon(name)
    }

    suspend fun getGen1Pokemon(limit: String): Response<PokemonGen1ResponseDTO> {
        return service.getGen1Pokemon(limit)
    }

    interface PokemonApiService {

        @GET("/api/v2/pokemon/{name}")
        suspend fun getSinglePokemon(
            @Path("name") name: String,
        ): Response<SinglePokemonResponseDTO>

        @GET("/api/v2/pokemon")
        suspend fun getGen1Pokemon(
            @Query("limit") limit: String,
        ): Response<PokemonGen1ResponseDTO>
    }
}
