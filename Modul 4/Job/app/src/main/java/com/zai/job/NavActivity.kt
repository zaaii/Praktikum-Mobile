package com.zai.job

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.content.res.Configuration
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.zai.job.databinding.ActivityNavActivityBinding
import java.util.*

class NavActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarNavActivity.toolbar)

        binding.appBarNavActivity.fab.setOnClickListener { view ->
            Snackbar.make(view, "Halo ~", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_nav_activity)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_vacancy, R.id.nav_news
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //Opsi Ganti Bahasa
            R.id.indonesia -> {
                val locale = Locale("in", "ID")
                Locale.setDefault(locale)
                val config = Configuration()
                config.locale = locale
                baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
                Toast.makeText(this, "Language changed to indonesia", Toast.LENGTH_SHORT).show()
                recreate()
                return true
            }
            R.id.inggris -> {
                val locale = Locale("en", "EN")
                Locale.setDefault(locale)
                val config = Configuration()
                config.locale = locale
                baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
                Toast.makeText(this, "Language changed to Inggris", Toast.LENGTH_SHORT).show()
                recreate()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_nav_activity)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}