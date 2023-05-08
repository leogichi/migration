package com.leogichi.lgm.infrastructure

import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.domain.models.PokemonResponse
import com.leogichi.lgm.domain.models.Pokemons
import com.leogichi.lgm.infrastructure.network.PokemonService
import javax.inject.Inject

class Repository @Inject constructor(val pokemonService: PokemonService) {
    suspend fun getPokemons(pokemonName:String): Pokemon?{
        val some = pokemonService.getPokemons(pokemonName)
        val result = some
        return result
    }
}