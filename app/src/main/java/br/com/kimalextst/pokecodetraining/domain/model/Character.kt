package br.com.kimalextst.pokecodetraining.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val gender: String
) : Parcelable