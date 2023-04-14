package com.leogichi.lgm.infrastructure

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.presentation.ResultState
import com.leogichi.lgm.usecases.GetPokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class HomeViewModel @Inject constructor(val getPokemonsUseCase: GetPokemons): ViewModel() {
    private val _pokemons by lazy {
        MutableLiveData<ResultState?>()
    }
    // = MutableLiveData<ResultState?>(null)
    val pokemons  get() = _pokemons

    fun getPokemons(pokemonName:String){
        viewModelScope.launch(Dispatchers.IO) {
            _pokemons.postValue(ResultState.Loading)
            getPokemonsUseCase(pokemonName).let {
                _pokemons.postValue(it)
            }
        }

    }
}