package br.com.zup.rickandmorty.ui.home.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.movieflix.ui.viewstate.ViewState
import br.com.zup.rickandmorty.CHARACTER_KEY
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.databinding.FragmentListBinding
import br.com.zup.rickandmorty.ui.characterdetail.CharacterDetailsActivity
import br.com.zup.rickandmorty.ui.home.adapter.CharacterAdapter
import br.com.zup.rickandmorty.ui.home.viewmodel.CharacterListViewModel

class ListFragment : Fragment() {

        private lateinit var binding: FragmentListBinding

        private val viewModel: CharacterListViewModel by lazy {
            ViewModelProvider(this)[CharacterListViewModel::class.java]
        }

        private val adapter: CharacterAdapter by lazy {
            CharacterAdapter(arrayListOf(), this::goToCharacterDetail)
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentListBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

//            showRecyclerView()
//            viewModel.getAllCharacters()
//            initObserver()
        }

    override fun onResume() {
        super.onResume()

        showRecyclerView()
        viewModel.getAllCharacters()
        initObserver()
    }


        private fun initObserver() {
            viewModel.characterList.observe(this.viewLifecycleOwner) {

                when (it) {
                    is ViewState.Success -> {
                        adapter.updateCharacterList(it.data.toMutableList())
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


        private fun showRecyclerView() {

            binding.rvCharacter.adapter = adapter
            val layoutManager = GridLayoutManager(requireContext(),2)
            binding.rvCharacter.layoutManager = layoutManager
        }

        private fun goToCharacterDetail(character: CharacterResult) {
            val bundle = bundleOf(CHARACTER_KEY to character)
            val intent = Intent(requireContext(), CharacterDetailsActivity::class.java).apply {
                putExtra(CHARACTER_KEY,bundle)
            }
            startActivity(intent)
        }
}