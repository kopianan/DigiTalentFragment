package com.kopianan.digitalentsubmission

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    var toolbar: ActionBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar

        setLocale()

        var fragment: Fragment
        fragment = MovieFragment()
        loadFragment(fragment)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelected)
    }

    fun getData(): String {
        val mSettings = PreferenceManager.getDefaultSharedPreferences(this)

        try {
            mSettings.getString("lang", "")
        } catch (e: Exception) {
            return ""
        }

        return mSettings.getString("lang", "").toString()

    }


    private fun setLocale() {
        var myLocale: Locale? = null
        myLocale = Locale(getData())
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.setting_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_setting -> {
                val intent = Intent(this.applicationContext, SettingActivity::class.java)
                startActivity(intent)

            }
        }
        return super.onOptionsItemSelected(item)
    }


    var mOnNavigationItemSelected: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                var fragment: Fragment
                when (p0.itemId) {
                    R.id.navigation_movie -> {
                        toolbar!!.title = getString(R.string.title_movie)
                        fragment = MovieFragment()
                        loadFragment(fragment)
                        return true
                    }
                    R.id.navigation_tv -> {
                        toolbar!!.title = getString(R.string.title_tv_show)
                        fragment = TvShowFragment()
                        loadFragment(fragment)
                        return true
                    }
                }
                return false
            }

        }

    fun loadFragment(fragment: Fragment) {
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
