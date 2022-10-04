package br.com.zup.rickandmorty.domain.repository

import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty.data.model.CharacterResponse
import javax.inject.Inject

class CharacterRepository @Inject constructor() {

    suspend fun getAllCharactersNetwork(): CharacterResponse {
        return RetrofitService.apiService.getCharactersNetwork()
    }
}