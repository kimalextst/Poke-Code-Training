package br.com.zup.rickandmorty.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.movieflix.ui.viewstate.ViewState
import br.com.zup.rickandmorty.JPEG
import br.com.zup.rickandmorty.URL_BASE_IMG
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.databinding.CharacterItemBinding
import com.squareup.picasso.Picasso
import kotlin.reflect.KFunction1

class CharacterAdapter(
    private var characterList: MutableList<CharacterResult>,
    private val characterClick: KFunction1<CharacterResult, Unit>
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
        if (characterList.size == 0) {
            characterList = newList as MutableList<CharacterResult>
        } else {
            characterList.addAll(newList as Collection<CharacterResult>)
        }
        notifyDataSetChanged()
    }

    class CharacterViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showCharacterInfo(characterResult: CharacterResult) {
            Picasso.get().load(URL_BASE_IMG + characterResult.id + JPEG)
                .into(binding.ivCharacter)
            binding.tvCharacterName.text = characterResult.name
        }
    }
}