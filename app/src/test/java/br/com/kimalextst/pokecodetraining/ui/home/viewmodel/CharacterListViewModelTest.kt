package br.com.kimalextst.pokecodetraining.ui.home.viewmodel

import app.cash.turbine.test
import br.com.kimalextst.pokecodetraining.core.CoroutinesTestRule
import br.com.kimalextst.pokecodetraining.domain.usecase.CharacterUseCase
import br.com.kimalextst.pokecodetraining.ui.viewstate.ViewState
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class CharacterListViewModelTest {

    @get: Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val useCase : CharacterUseCase = mockk(relaxed = true)
    lateinit var viewModel: CharacterListViewModel

    @Before
    fun setup(){
        viewModel = CharacterListViewModel(useCase)

        coEvery { useCase.getAllCharactersNetwork() } returns flow { throw Throwable() }
    }

    @Test
    fun WhenErrorShouldEmitErrorState() = runTest {
        viewModel.characterList.test {
            Truth.assertThat(expectItem()).isEqualTo(ViewState.Loading(true))
            Truth.assertThat(expectItem()).isEqualTo(ViewState.Error(Throwable("Error")))
        }
    }

}