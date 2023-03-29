package br.com.kimalextst.pokecodetraining.domain.usecase

import br.com.kimalextst.pokecodetraining.domain.model.Character
import br.com.kimalextst.pokecodetraining.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
) {

    fun getAllCharactersNetwork(): Flow<List<Character>> {
        return characterRepository.getAllCharactersNetwork()
    }
}