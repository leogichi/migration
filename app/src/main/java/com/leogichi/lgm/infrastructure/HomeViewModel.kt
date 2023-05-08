package com.leogichi.lgm.infrastructure

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.presentation.ResultState
import com.leogichi.lgm.usecases.GetPokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class HomeViewModel @Inject constructor(val getPokemonsUseCase: GetPokemons): ViewModel() {
    private var pokemonName = ""
    private val _pokemons  =
        flow {
            val result =  getPokemonsUseCase(pokemonName)
            emit(ResultState.Loading)
            emit(result)
        }

    // = MutableLiveData<ResultState?>(null)
    val pokemons  get() = _pokemons

     fun getPokemons(pokemonName:String){
        this.pokemonName = pokemonName
    }

}