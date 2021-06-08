package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.utils

import android.content.Context
import android.content.SharedPreferences
import com.rsh_engineering.tkachenkoni.checkpressurelist.App
import com.rsh_engineering.tkachenkoni.checkpressurelist.AppConstants

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
class SharedPreferencesUtils {
    private var context: Context? = null
    private var sharedPrefs: SharedPreferences? = null

    fun SharedPreferencesUtils() {
        context = App.instance.applicationContext
        sharedPrefs =
            context!!.getSharedPreferences(AppConstants.SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getSharedPrefs(): SharedPreferences? {
        return sharedPrefs
    }

    fun AddSharedPrefsString(_key: String?, _value: String?) {
        val lEditor = sharedPrefs!!.edit()
        lEditor.putString(_key, _value)
        lEditor.apply()
    }

    fun AddSharedPrefsInt(_key: String?, _value: Int) {
        val lEditor = sharedPrefs!!.edit()
        lEditor.putInt(_key, _value)
        lEditor.apply()
    }

    fun AddSharedPrefsBoolean(_key: String?, _value: Boolean) {
        val lEditor = sharedPrefs!!.edit()
        lEditor.putBoolean(_key, _value)
        lEditor.apply()
    }
}