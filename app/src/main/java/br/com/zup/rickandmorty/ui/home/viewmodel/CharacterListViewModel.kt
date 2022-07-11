package br.com.zup.rickandmorty.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import br.com.zup.movieflix.ui.viewstate.ViewState
import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.domain.usecase.CharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterListViewModel() : ViewModel() {
    private val characterUseCase = CharacterUseCase()
    private var _characterList = MutableLiveData<ViewState<List<CharacterResult>>>()
    var characterList = _characterList

    fun getAllCharacters() {
        viewModelScope.launch {
            try {
                var response = withContext(Dispatchers.IO) {
                    characterUseCase.getAllCharactersNetwork()
                }
                characterList.value = response
            } catch (e: Exception) {
                Log.v("ERRO", "teste teste teste")
                characterList.value =
                    ViewState.Error(Throwable("Error"))
            }
        }
    }

}
