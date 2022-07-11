package br.com.zup.rickandmorty.ui.characterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.rickandmorty.R

class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        exibirAppBarCustomizada()
}

private fun exibirAppBarCustomizada() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setTitle("teste")
}
}