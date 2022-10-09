package br.com.zup.rickandmorty.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.rickandmorty.core.loadImage
import br.com.zup.rickandmorty.databinding.DeadCharacterItemBinding
import br.com.zup.rickandmorty.domain.model.Character

class DeadCharacterAdapter(
    private var characterList: List<Character>,
    private val characterClick: (characterResult: Character) -> Unit
) : RecyclerView.Adapter<DeadCharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            DeadCharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.showCharacterInfo(character)
        holder.binding.cvItemLista.setOnClickListener {
            characterClick(character)
        }
    }

    override fun getItemCount(): Int = characterList.size

    class CharacterViewHolder(val binding: DeadCharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showCharacterInfo(characterResult: Character) {
            if (characterResult.status.value == "Dead") {
                binding.ivCharacter.loadImage(characterResult.imageUrl)
                binding.tvCharacterName.text = characterResult.name
            } else {
                binding.cvItemLista.visibility = View.GONE
            }
        }
    }
}