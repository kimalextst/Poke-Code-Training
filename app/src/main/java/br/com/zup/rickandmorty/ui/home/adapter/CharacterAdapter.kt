package br.com.zup.rickandmorty.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.rickandmorty.R
import br.com.zup.rickandmorty.core.loadImage
import br.com.zup.rickandmorty.domain.model.Character

class CharacterAdapter(
    context: Context,
    private var characterList: List<Character>,
    private val characterClick: (characterResult: Character) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val THE_FIRST_VIEW = 1
        const val THE_SECOND_VIEW = 2
    }

    private val yourContext: Context = context

    private inner class DeadViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.tvCharacterName)
        var image: AppCompatImageView = itemView.findViewById(R.id.ivCharacter)
        fun bind(position: Int) {
            val recyclerViewModel = characterList[position]
            text.text = recyclerViewModel.name
            image.loadImage(recyclerViewModel.imageUrl)
        }
    }

    private inner class AliveViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var text: TextView = itemView.findViewById(R.id.tvCharacterName)
        var image: AppCompatImageView = itemView.findViewById(R.id.ivCharacter)
        fun bind(position: Int) {
            val recyclerViewModel = characterList[position]
            text.text = recyclerViewModel.name
            image.loadImage(recyclerViewModel.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == THE_FIRST_VIEW) {
            return DeadViewHolder(
                LayoutInflater.from(yourContext).inflate(R.layout.dead_character_item, parent, false)
            )
        }
        return AliveViewHolder(
            LayoutInflater.from(yourContext).inflate(R.layout.alive_character_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (characterList[position].status.ordinal == THE_FIRST_VIEW) {
            (holder as DeadViewHolder).bind(position)
        } else {
            (holder as AliveViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return characterList[position].status.ordinal
    }
}

