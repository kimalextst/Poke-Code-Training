package br.com.kimalextst.pokecodetraining.domain.mapper

import br.com.kimalextst.pokecodetraining.data.model.CharacterResponse
import br.com.kimalextst.pokecodetraining.data.model.CharacterResultResponse
import br.com.kimalextst.pokecodetraining.domain.model.Character
import br.com.kimalextst.pokecodetraining.domain.model.CharacterStatus
import javax.inject.Inject

class CharacterMapper @Inject constructor() {

    fun toCharacterList(moviesResponse: CharacterResponse): List<Character> {
        return moviesResponse.results.map { it.toCharacter() }
    }

    private fun CharacterResultResponse.toCharacter(): Character {
        return Character(
            id = this.id,
            name = this.name,
            imageUrl = this.image,
            status = CharacterStatus.find(this.status),
            species = this.species,
            gender = this.gender
        )
    }
}