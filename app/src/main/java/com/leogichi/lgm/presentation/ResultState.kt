package com.leogichi.lgm.presentation

sealed class ResultState{
    class Success<T>(val data: T) : ResultState()
    class Error(val message: String?) : ResultState()
    object Loading : ResultState()

}
