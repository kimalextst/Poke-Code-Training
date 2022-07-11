package br.com.zup.rickandmorty.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.rickandmorty.databinding.CharacterItemBinding
import br.com.zup.rickandmorty.domain.model.Character

class CharacterAdapter (
    private var characterList: MutableList<Character>,
    private val characterClick: (album: Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val album = characterList[position]
        holder.adicionarInformacoesView(album)
        holder.binding.cvItemLista.setOnClickListener {
            characterClick(album)
        }
    }

    override fun getItemCount(): Int = characterList.size

    class CharacterViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun adicionarInformacoesView(album : Character) {
            binding.ivCharacter.setImageResource(album.getImage())
        }
    }
}