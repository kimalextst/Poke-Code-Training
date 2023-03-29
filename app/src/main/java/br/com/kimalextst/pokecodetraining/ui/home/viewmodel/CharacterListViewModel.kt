package br.com.kimalextst.pokecodetraining.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.kimalextst.pokecodetraining.domain.model.Character
import br.com.kimalextst.pokecodetraining.domain.usecase.CharacterUseCase
import br.com.kimalextst.pokecodetraining.ui.viewstate.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    private var _characterList = MutableStateFlow<ViewState<List<Character>>>(ViewState.Loading(true))
    var characterList = _characterList.asStateFlow()

    fun getAllCharacters() {
        viewModelScope.launch {
            characterUseCase.getAllCharactersNetwork()
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.v("ERRO", "teste teste teste")
                    _characterList.value = ViewState.Error(Throwable("Error"))
                }.collect {
                    _characterList.value = ViewState.Success(it)
                }
        }
    }
}
