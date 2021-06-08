package com.rsh_engineering.tkachenkoni.checkpressurelist.di.module

import android.content.Context
import com.rsh_engineering.tkachenkoni.checkpressurelist.App
import com.rsh_engineering.tkachenkoni.checkpressurelist.di.scope.AppScope
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.DataBaseServices
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.HumanPropertyEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.PressureItemEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.WeightItemEntityDao
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
    fun provideDataBaseServices(): DataBaseServices {
        return DataBaseServices.getDatabase(context = App.instance.applicationContext)
    }

    @Provides
    fun provideHumanPropertyEntityDao(): HumanPropertyEntityDao =
        DataBaseServices
            .getDatabase(context = App.instance.applicationContext)
            .humanPropertyEntityDao()

    @Provides
    fun providePressureItemEntityDao(): PressureItemEntityDao =
        DataBaseServices
            .getDatabase(context = App.instance.applicationContext)
            .pressureItemEntityDao()

    @Provides
    fun provideWeightItemEntityDao(): WeightItemEntityDao =
        DataBaseServices
            .getDatabase(context = App.instance.applicationContext)
            .weightItemEntityDao()
}