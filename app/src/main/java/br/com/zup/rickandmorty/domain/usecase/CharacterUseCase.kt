package br.com.zup.rickandmorty.domain.usecase

import br.com.zup.rickandmorty.domain.mapper.CharacterMapper
import br.com.zup.rickandmorty.domain.model.Character
import br.com.zup.rickandmorty.domain.repository.CharacterRepository
import br.com.zup.rickandmorty.ui.viewstate.ViewState
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val mapper: CharacterMapper
) {

    suspend fun getAllCharactersNetwork(): ViewState<List<Character>> {
        return try {
            val response = characterRepository.getAllCharactersNetwork()
            ViewState.Success(mapper.toCharacterList(response))
        } catch (ex: Exception) {
            ViewState.Error(Exception("Não foi possivel carregar a lista"))
        }
    }
}