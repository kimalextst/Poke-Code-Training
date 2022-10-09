package br.com.zup.rickandmorty.domain.model

enum class CharacterStatus(val value: String) {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("unknown");

    companion object {
        fun find(value: String): CharacterStatus {
            return values().find { it.value == value } ?: UNKNOWN
        }
    }
}