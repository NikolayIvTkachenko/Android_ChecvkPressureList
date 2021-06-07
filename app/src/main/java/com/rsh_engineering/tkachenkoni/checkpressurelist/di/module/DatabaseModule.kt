package com.rsh_engineering.tkachenkoni.checkpressurelist.di.module

import android.content.Context
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.scope.AppScope
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.DataBaseServices
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@Module
class DatabaseModule {

    @Provides
    fun provideDataBaseServices(context: Context): DataBaseServices? {
        return DataBaseServices.getDatabase(context = context)
    }

}