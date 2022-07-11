package br.com.zup.rickandmorty.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.databinding.CharacterItemBinding
import com.squareup.picasso.Picasso

class CharacterAdapter(
    private var characterList: MutableList<CharacterResult>,
    private val characterClick: (characterResult : CharacterResult) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character : CharacterResult = characterList[position]
        holder.showCharacterInfo(character)
        holder.binding.cvItemLista.setOnClickListener {
            characterClick(character)
        }
    }

    override fun getItemCount(): Int = characterList.size

    fun updateCharacterList(newList: MutableList<CharacterResult>) {
        characterList = newList
        notifyDataSetChanged()
    }

    class CharacterViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showCharacterInfo(characterResult: CharacterResult) {
            Picasso.get().load(characterResult.image)
                .into(binding.ivCharacter)
            binding.tvCharacterName.text = characterResult.name
        }
    }
}