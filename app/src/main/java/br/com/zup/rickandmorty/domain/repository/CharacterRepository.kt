package br.com.zup.rickandmorty.domain.repository

import br.com.zup.rickandmorty.data.datasource.remote.CharacterAPI
import br.com.zup.rickandmorty.data.model.CharacterResponse
import br.com.zup.rickandmorty.domain.mapper.CharacterMapper
import br.com.zup.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterAPI,
    private val mapper: CharacterMapper
) {

    fun getAllCharactersNetwork(): Flow<List<Character>> {
        return flow {
            emit(api.getCharactersNetwork())
        }
            .map {
                mapper.toCharacterList(it)
            }
    }
}