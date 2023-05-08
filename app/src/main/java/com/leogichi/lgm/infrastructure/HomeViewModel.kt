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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class HomeViewModel @Inject constructor(val getPokemonsUseCase: GetPokemons): ViewModel() {

    private val _pokemon = MutableStateFlow<ResultState>(ResultState.Loading)
    val pokemon  get() = _pokemon

     fun getPokemons(pokemonName:String){
        viewModelScope.launch {
            _pokemon.emit(getPokemonsUseCase.invoke(pokemonName))
        }

    }

}