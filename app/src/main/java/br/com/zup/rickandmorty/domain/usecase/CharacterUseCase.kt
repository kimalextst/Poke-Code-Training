package br.com.zup.rickandmorty.domain.usecase

import br.com.zup.rickandmorty.domain.mapper.CharacterMapper
import br.com.zup.rickandmorty.domain.model.Character
import br.com.zup.rickandmorty.domain.repository.CharacterRepository
import br.com.zup.rickandmorty.ui.viewstate.ViewState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
) {

    fun getAllCharactersNetwork(): Flow<List<Character>> {
        return characterRepository.getAllCharactersNetwork()
    }
}