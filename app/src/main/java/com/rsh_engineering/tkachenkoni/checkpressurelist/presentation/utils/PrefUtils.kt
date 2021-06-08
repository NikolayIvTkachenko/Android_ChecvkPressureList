package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.utils

import android.content.Context
import android.content.SharedPreferences
import com.rsh_engineering.tkachenkoni.checkpressurelist.AppConstants

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
class PrefUtils(context: Context) {


    private var sp: SharedPreferences? = null

    companion object{

        private var instance: PrefUtils? = null

        fun getInstance(context: Context?): PrefUtils? {
            if (instance == null) {
                instance = PrefUtils(context!!)
            }
            return instance
        }
    }

    fun PrefUtils(context: Context) {
        sp = context.getSharedPreferences(AppConstants.SHARED_PREFS, Context.MODE_PRIVATE)
    }

    fun saveTokenPurchase(token: String?) {
        sp!!.edit().putString(AppConstants.token_purchase, token).apply()
    }

    fun loadToken(): String? {
        return sp!!.getString(AppConstants.token_purchase, "")
    }


    fun getMarkPurchased(): Boolean {
        return sp!!.getBoolean(AppConstants.marker_purchased, false)
    }

    fun setMarkPurchased(markPurchased: Boolean) {
        sp!!.edit().putBoolean(AppConstants.marker_purchased, markPurchased).apply()
    }

    fun addAdsCount() {
        sp!!.edit().putInt(AppConstants.ADS_COUNT, sp!!.getInt(AppConstants.ADS_COUNT, 0) + 1).apply()
    }

    fun saveAdsCount(ads: Int) {
        sp!!.edit().putInt(AppConstants.ADS_COUNT, ads).apply()
    }

    fun loadAdsCount(): Int {
        return sp!!.getInt(AppConstants.ADS_COUNT, 0)
    }


}