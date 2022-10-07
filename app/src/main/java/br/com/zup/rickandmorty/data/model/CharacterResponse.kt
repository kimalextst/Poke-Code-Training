package br.com.zup.rickandmorty.data.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    var info: CharacterInfoResponse,
    @SerializedName("results")
    var results: List<CharacterResultResponse>
)