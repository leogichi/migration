package com.leogichi.lgm.infrastructure.network

import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.domain.models.PokemonResponse
import com.leogichi.lgm.domain.models.Pokemons
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {
    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemons(@Path("name") name:String): Pokemon
}