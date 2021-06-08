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

    @Transaction
    @Query("SELECT * FROM pressure WHERE Id = :Id")
    fun getPressureItemByCurrentId(Id: Long) : PressureItemEntity

    @Transaction
    @Query("SELECT * FROM pressure")
    fun getListPressureItem(): List<PressureItemEntity>

    @Insert
    fun insert(pressureItemEntity: PressureItemEntity?)

    @Update
    fun update(pressureItemEntity: PressureItemEntity?)

    @Delete
    fun delete(pressureItemEntity: PressureItemEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPressureItemEntity(pressureItemEntity: PressureItemEntity?)

}