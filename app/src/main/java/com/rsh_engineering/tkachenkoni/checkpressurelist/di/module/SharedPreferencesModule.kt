package com.rsh_engineering.tkachenkoni.checkpressurelist.di.module

import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.utils.SharedPreferencesUtils
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
@Module
class SharedPreferencesModule {

    @Provides
    fun provideSharedPreferencesUtils(): SharedPreferencesUtils? = SharedPreferencesUtils()

}