package com.leogichi.lgm.infrastructure.network

import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.domain.models.PokemonResponse
import com.leogichi.lgm.domain.models.Pokemons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonService @Inject constructor(val api: PokemonAPI){
    suspend fun getPokemons(pokemonName:String): Pokemon? {
        var result :Pokemon?= null
         withContext(Dispatchers.IO){
             result = api.getPokemons(pokemonName)
             val some = result
        }
        return result
    }
}