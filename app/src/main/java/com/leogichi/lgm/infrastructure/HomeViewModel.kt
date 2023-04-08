package com.leogichi.lgm.infrastructure

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leogichi.lgm.domain.PokemonProvider
import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.usecases.GetPokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getPokemonsUseCase: GetPokemons): ViewModel() {
    private val _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(emptyList())
    val pokemons  get() = _pokemons

    fun getPokemons(pokemonName:String){
        viewModelScope.launch(Dispatchers.IO) {
            getPokemonsUseCase(pokemonName).let {
                _pokemons.postValue(it)
            }
        }

    }
}