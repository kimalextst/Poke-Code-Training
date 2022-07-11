package br.com.zup.rickandmorty.domain.usecase

import android.app.Application
import br.com.zup.movieflix.ui.viewstate.ViewState
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.domain.repository.CharacterRepository

class CharacterUseCase(application: Application) {
    private val characterRepository = CharacterRepository()

    suspend fun getAllMoviesNetwork(): ViewState<List<CharacterResult>> {
        return try {
            val response = characterRepository.getAllCharactersNetwork()
            ViewState.Success (response.characterResults)
        }catch (ex: Exception){
            ViewState.Error(Exception("Não foi possivel carregar a lista"))
        }
    }
}