package br.com.zup.rickandmorty.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.rickandmorty.CHARACTER_KEY
import br.com.zup.rickandmorty.R
import br.com.zup.rickandmorty.databinding.FragmentListBinding
import br.com.zup.rickandmorty.domain.model.Character
import br.com.zup.rickandmorty.ui.home.adapter.CharacterAdapter
import br.com.zup.rickandmorty.ui.home.viewmodel.CharacterListViewModel
import br.com.zup.rickandmorty.ui.viewstate.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel: CharacterListViewModel by lazy {
        ViewModelProvider(this)[CharacterListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as HomeActivity).supportActionBar?.setTitle(R.string.app_name)

        viewModel.getAllCharacters()
        initObserver()
    }

    private fun initObserver() {
        viewModel.characterList.observe(this.viewLifecycleOwner) {

            when (it) {
                is ViewState.Success -> {
                    initRecyclerView(it.data)
                }
                is ViewState.Error -> {
                    Toast.makeText(
                        context,
                        "${it.throwable.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {}
            }
        }
    }

    private fun initRecyclerView(data: List<Character>) {
        binding.rvCharacter.adapter = CharacterAdapter(data, this::goToCharacterDetail)
    }

    private fun goToCharacterDetail(character: Character) {
        val bundle = bundleOf(CHARACTER_KEY to character)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_listFragment_to_characterDetailFragment, bundle)
    }
}