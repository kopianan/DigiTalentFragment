package com.kopianan.digitalentsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.*
import android.preference.PreferenceManager
import android.widget.Toast
import java.lang.Exception


class SettingActivity : AppCompatActivity() {
    var myLocale: Locale? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setTitle(R.string.change_language)

        if (getData() == "") {
            rdb_bahasa.isChecked = true
            saveData("id")

        }else if (getData() =="en"){
            rdb_english.isChecked = true
        }else if (getData() == "id"){
            rdb_bahasa.isChecked = true
        }

//        if (getData() == "en") {
//            rdb_english.isChecked = true
//
//        } else if (getData() == "id") {
//            rdb_bahasa.isChecked = true
//        }


        rdb_bahasa.setOnClickListener {
            saveData("id")
        }
        rdb_english.setOnClickListener {
            saveData("en")
        }
    }


    fun saveData(lang: String) {

        val mSettings = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = mSettings.edit()

        editor.putString("lang", lang)
        editor.apply()

        myLocale = Locale(getData())
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)

        val intent = Intent(this.applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)

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
}
