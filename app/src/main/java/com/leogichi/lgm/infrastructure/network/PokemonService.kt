package com.leogichi.lgm.infrastructure.network

import com.leogichi.lgm.domain.models.Pokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonService @Inject constructor(val api: PokemonAPI){
    suspend fun getPokemons(pokemonName:String):List<Pokemon> {
        return withContext(Dispatchers.IO){

              api.getPokemons(pokemonName).body() ?: emptyList()
        }
    }
}