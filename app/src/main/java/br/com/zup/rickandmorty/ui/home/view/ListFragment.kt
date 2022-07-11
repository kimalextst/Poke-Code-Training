package br.com.zup.rickandmorty.ui.home.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.rickandmorty.databinding.FragmentListBinding
import br.com.zup.rickandmorty.ui.detalhes.DetailsActivity
import br.com.zup.rickandmorty.ui.home.adapter.CharacterAdapter
import br.com.zup.rickandmorty.domain.model.Character

class ListFragment : Fragment() {
    class FotosFragment : Fragment() {

        private lateinit var binding: FragmentListBinding

        private val adapter: CharacterAdapter by lazy {
            CharacterAdapter(arrayListOf(), this::irParaDetalhe)
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

            exibirRecyclerView()
        }

        private fun exibirRecyclerView() {

            binding.rvCharacter.adapter = adapter
            val layoutManager = GridLayoutManager(requireContext(),2)
            binding.rvCharacter.layoutManager = layoutManager
        }

        private fun irParaDetalhe(character: Character) {
            val intent = Intent(requireContext(), DetailsActivity::class.java)
            startActivity(intent)
        }
    }
}