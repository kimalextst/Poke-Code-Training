package br.com.kimalextst.pokecodetraining.di

import br.com.kimalextst.pokecodetraining.data.datasource.remote.CharacterAPI
import br.com.kimalextst.pokecodetraining.data.datasource.remote.RetrofitService
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