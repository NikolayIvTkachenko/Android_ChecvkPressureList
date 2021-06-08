package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao

import androidx.room.*
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.PressureItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.HumanProperty
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.PressureItem

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@Dao
interface PressureItemEntityDao {

    @Query("SELECT * FROM human WHERE Id = :Id")
    fun getPressureItemByCurrentId(Id: Long) : PressureItem

    @Query("SELECT * FROM human")
    fun getListPressureItem(): List<PressureItem>

    @Insert
    fun insert(pressureItemEntity: PressureItemEntity?)

    @Update
    fun update(pressureItemEntity: PressureItemEntity?)

    @Delete
    fun delete(pressureItemEntity: PressureItemEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPressureItemEntity(pressureItemEntity: PressureItemEntity?)

}