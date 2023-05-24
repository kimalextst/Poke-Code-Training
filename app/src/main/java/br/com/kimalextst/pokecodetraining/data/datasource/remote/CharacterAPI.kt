package br.com.kimalextst.pokecodetraining.data.datasource.remote

import br.com.kimalextst.pokecodetraining.data.model.CharacterResponse
import retrofit2.http.GET

interface CharacterAPI {
    @GET ("character")
    suspend fun getCharactersNetwork() : CharacterResponse
}
