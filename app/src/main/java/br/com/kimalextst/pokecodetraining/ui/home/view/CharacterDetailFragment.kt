package br.com.kimalextst.pokecodetraining.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.kimalextst.pokecodetraining.CHARACTER_KEY
import br.com.kimalextst.pokecodetraining.core.loadImage
import br.com.kimalextst.pokecodetraining.databinding.FragmentCharacterDetailBinding
import br.com.kimalextst.pokecodetraining.domain.model.Character

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getCharacterDetail()
    }

    private fun getCharacterDetail() {
        val character = arguments?.getParcelable<Character>(CHARACTER_KEY)

        character?.let {
            binding.ivCharacterPhoto.loadImage(it.imageUrl)

            binding.tvNome.text = it.name
            binding.tvEspecie.text = it.species
            binding.tvGenero.text = it.gender
            binding.tvStatus.text = it.status.value
            (activity as HomeActivity).supportActionBar?.title = it.name
        }
    }
}