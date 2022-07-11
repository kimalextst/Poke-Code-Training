package br.com.zup.rickandmorty.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterResult(
    @SerializedName("created")
    var created: String = "",
    @SerializedName("episode")
    var episode: List<String> = listOf(),
    @SerializedName("gender")
    var gender: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image")
    var image: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("species")
    var species: String = "",
    @SerializedName("status")
    var status: String = "",
    @SerializedName("type")
    var type: String = "",
    @SerializedName("url")
    var url: String = ""
) : Parcelable