package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao

import androidx.room.*
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.TemperatureItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.WeightItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 24, June, 2021
 *
 */
@Dao
interface TemperatureEntityDao {

    @Insert
    fun insert(item: TemperatureItemEntity?)

    @Update
    fun update(item: TemperatureItemEntity?)

    @Delete
    fun delete(item: TemperatureItemEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeightItemEntity(item: TemperatureItemEntity?)

}