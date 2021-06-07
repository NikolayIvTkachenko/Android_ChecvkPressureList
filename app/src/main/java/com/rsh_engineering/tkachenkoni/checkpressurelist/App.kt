package com.rsh_engineering.tkachenkoni.checkpressurelist

import android.app.Application
import android.content.Context
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.component.AppComponent
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.component.DaggerAppComponent

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
class App : Application() {
    lateinit var appComponent : AppComponent

    companion object{
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = this.initDagger()
    }

    private fun initDagger() = DaggerAppComponent.builder()
        .build()


    val Context.app: App
        get() = applicationContext as App
}