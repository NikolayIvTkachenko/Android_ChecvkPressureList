package com.rsh_engineering.tkachenkoni.checkpressurelist.di.component

import android.app.Activity
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.module.DatabaseModule
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.scope.AppScope
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.MainActivity
import dagger.Component

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@AppScope
@Component(
    modules = [
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}