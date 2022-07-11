package br.com.zup.rickandmorty.ui.viewstate


sealed class ViewState<out T> {
    data class Success<T>(var data: T) : ViewState<T>()
    data class Error(var throwable: Throwable) : ViewState<Nothing>()
    data class Loading(var loading: Boolean) : ViewState<Nothing>()
}
