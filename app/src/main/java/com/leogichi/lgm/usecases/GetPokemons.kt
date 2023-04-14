package com.leogichi.lgm.usecases

import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.infrastructure.Repository
import com.leogichi.lgm.presentation.ResultState
import javax.inject.Inject

class GetPokemons @Inject constructor(val repository: Repository) {

    suspend operator fun invoke(pokemonName:String):ResultState{
        repository.getPokemons("picachu")
        return ResultState.Error("Hola")
    }

}