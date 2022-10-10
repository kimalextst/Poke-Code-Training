package br.com.zup.rickandmorty.di

import br.com.zup.rickandmorty.data.datasource.remote.CharacterAPI
import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): CharacterAPI {
        return RetrofitService.apiService
    }
}