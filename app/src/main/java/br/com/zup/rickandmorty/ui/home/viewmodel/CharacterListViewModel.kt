package br.com.zup.rickandmorty.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.movieflix.ui.viewstate.ViewState
import br.com.zup.rickandmorty.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.domain.usecase.CharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterListViewModel(application: Application) : AndroidViewModel(application) {
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
                characterList.value =
                    ViewState.Error(Throwable("Error"))
            }
        }
    }

}
