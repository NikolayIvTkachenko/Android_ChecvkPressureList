package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao

import androidx.room.*
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.WeightItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@Dao
interface WeightItemEntityDao {

    @Insert
    fun insert(weightItemEntity: WeightItemEntity?)

    @Update
    fun update(weightItemEntity: WeightItemEntity?)

    @Delete
    fun delete(weightItemEntity: WeightItemEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeightItemEntity(weightItemEntity: WeightItemEntity?)

}