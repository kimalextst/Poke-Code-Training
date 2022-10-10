package br.com.zup.rickandmorty.domain.repository

import br.com.zup.rickandmorty.data.datasource.remote.CharacterAPI
import br.com.zup.rickandmorty.data.model.CharacterResponse
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterAPI
) {

    suspend fun getAllCharactersNetwork(): CharacterResponse {
        return api.getCharactersNetwork()
    }
}