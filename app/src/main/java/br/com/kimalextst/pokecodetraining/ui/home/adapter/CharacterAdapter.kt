package br.com.kimalextst.pokecodetraining.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.kimalextst.pokecodetraining.R
import br.com.kimalextst.pokecodetraining.core.loadImage
import br.com.kimalextst.pokecodetraining.domain.model.Character
import br.com.kimalextst.pokecodetraining.domain.model.CharacterStatus

class CharacterAdapter(
    private var characterList: List<Character>,
    private val characterClick: (characterResult: Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    abstract class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var text: TextView = itemView.findViewById(R.id.tvCharacterName)
        private var image: AppCompatImageView = itemView.findViewById(R.id.ivCharacter)

        open fun bind(character: Character, characterClick: (characterResult: Character) -> Unit) {
            text.text = character.name
            image.loadImage(character.imageUrl)

            itemView.setOnClickListener {
                characterClick(character)
            }
        }
    }

    private inner class DeadViewHolder(itemView: View) : CharacterViewHolder(itemView) {
        var label: TextView = itemView.findViewById(R.id.labelStatus)

        override fun bind(
            character: Character, characterClick: (characterResult: Character) -> Unit
        ) {
            val newCharacter = character.copy(
                name = character.name.uppercase()
            )

            label.text = "Is DEAD"

            super.bind(newCharacter, characterClick)
        }
    }

    private inner class AliveViewHolder(itemView: View) : CharacterViewHolder(itemView) {
        var label: TextView = itemView.findViewById(R.id.labelAlive)

        override fun bind(
            character: Character,
            characterClick: (characterResult: Character) -> Unit
        ) {
            label.text = "Is Alive"
            super.bind(character, characterClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        if (viewType == CharacterStatus.DEAD.ordinal) {
            return DeadViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.dead_character_item, parent, false)
            )
        }
        return AliveViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.alive_character_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.bind(character, characterClick)
    }

    override fun getItemViewType(position: Int): Int {
        return characterList[position].status.ordinal
    }
}

