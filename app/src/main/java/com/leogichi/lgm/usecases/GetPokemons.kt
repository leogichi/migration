package com.leogichi.lgm.usecases

import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.infrastructure.Repository
import javax.inject.Inject

class GetPokemons @Inject constructor(val repository: Repository) {
    suspend operator fun invoke(pokemonName:String):List<Pokemon>{
        return repository.getPokemons(pokemonName)
    }

}