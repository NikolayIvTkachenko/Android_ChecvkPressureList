package com.rsh_engineering.tkachenkoni.checkpressurelist.di.component

import com.rsh_engineering.tkachenkoni.checkpressurelist.di.module.DatabaseModule
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.module.SharedPreferencesModule
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.scope.AppScope
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.activities.MainActivity
import dagger.Component

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@AppScope
@Component(
    modules = [
        DatabaseModule::class,
        SharedPreferencesModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}