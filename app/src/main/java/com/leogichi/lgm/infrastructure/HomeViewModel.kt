package com.leogichi.lgm.infrastructure

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leogichi.lgm.domain.PokemonProvider
import com.leogichi.lgm.domain.models.Pokemon

class HomeViewModel (): ViewModel() {
    private var _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(emptyList())
    val pokemons  get() = _pokemons

    fun getPokemons(){
        _pokemons.postValue(PokemonProvider().pokemons)
    }
}