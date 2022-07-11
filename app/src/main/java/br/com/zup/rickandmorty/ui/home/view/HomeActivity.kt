package br.com.zup.rickandmorty.ui.home.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.zup.rickandmorty.R
import br.com.zup.rickandmorty.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    private val navController : NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBarWithNavController(navController)


        exibirAppBarCustomizada()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setTitle(R.string.title_home)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}