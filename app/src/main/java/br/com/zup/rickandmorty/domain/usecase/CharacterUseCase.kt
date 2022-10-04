package br.com.zup.rickandmorty.domain.usecase

import br.com.zup.rickandmorty.ui.viewstate.ViewState
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterUseCase @Inject constructor(private val characterRepository : CharacterRepository) {

    suspend fun getAllCharactersNetwork(): ViewState<List<CharacterResult>> {
        return try {
            val response = characterRepository.getAllCharactersNetwork()
            ViewState.Success (response.results)
        }catch (ex: Exception){
            ViewState.Error(Exception("Não foi possivel carregar a lista"))
        }
    }
}