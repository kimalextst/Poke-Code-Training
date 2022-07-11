package br.com.zup.rickandmorty.data.datasource.remote

import br.com.zup.movieflix.ui.viewstate.ViewState
import br.com.zup.rickandmorty.data.model.CharacterResponse
import br.com.zup.rickandmorty.data.model.CharacterResult
import retrofit2.http.GET

interface CharacterAPI {
    @GET ("character")
    suspend fun getCharactersNetwork() : CharacterResponse
}