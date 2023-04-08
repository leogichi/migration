package com.leogichi.lgm.core.di

import com.leogichi.lgm.BuildConfig
import com.leogichi.lgm.infrastructure.network.PokemonAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.API_BASE_URL)
        addConverterFactory(GsonConverterFactory.create())//TODO recordar
    // que no debemos usar el factory converter en un proyecto real. Ya que el use case
        //Debe de transformar el json en su logica
    }.build()

    @Provides
    @Singleton
    fun providesClient(retrofit: Retrofit): PokemonAPI{
        return retrofit.create(PokemonAPI::class.java)
    }
}