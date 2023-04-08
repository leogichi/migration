package com.leogichi.lgm.infrastructure

import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.infrastructure.network.PokemonService
import javax.inject.Inject

class Repository @Inject constructor(val pokemonService: PokemonService) {
    suspend fun getPokemons(pokemonName:String):List<Pokemon>{
        return pokemonService.getPokemons(pokemonName)
    }
}