package br.com.zup.rickandmorty.data.model


import com.google.gson.annotations.SerializedName

data class CharacterInfoResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String?,
    @SerializedName("pages")
    var pages: Int = 0,
    @SerializedName("prev")
    var prev: String?
)