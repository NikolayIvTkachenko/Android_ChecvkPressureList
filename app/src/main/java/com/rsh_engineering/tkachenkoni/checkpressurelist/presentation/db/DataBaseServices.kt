package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rsh_engineering.tkachenkoni.checkpressurelist.AppConstants
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.HumanPropertyEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.PressureItemEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.WeightItemEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.domain.entity.HumanPropertyEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.domain.entity.PressureItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.domain.entity.WeightItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@Database(entities = [
    HumanPropertyEntity::class,
    PressureItemEntity::class,
    WeightItemEntity::class
                     ],
    version = AppConstants.VERSION_DB,
    exportSchema = false)
abstract class DataBaseServices: RoomDatabase() {

    abstract fun humanPropertyEntityDao(): HumanPropertyEntityDao
    abstract fun pressureItemEntityDao(): PressureItemEntityDao
    abstract fun weightItemEntityDao(): WeightItemEntityDao

    companion object {

        @Volatile
        private var INSTANCE: DataBaseServices? = null

        fun getDatabase(context: Context): DataBaseServices{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseServices::class.java,
                    AppConstants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}