package com.leogichi.lgm.infrastructure.network

import com.leogichi.lgm.domain.models.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {
    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemons(@Path("name") name:String):Response<List<Pokemon>>
}