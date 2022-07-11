package br.com.zup.rickandmorty.ui.home.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.rickandmorty.R
import br.com.zup.rickandmorty.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setTitle(R.string.title_home)
    }
}