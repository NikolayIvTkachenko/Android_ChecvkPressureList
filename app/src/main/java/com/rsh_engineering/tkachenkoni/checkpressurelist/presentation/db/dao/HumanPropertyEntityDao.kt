package com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao

import androidx.room.*
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.HumanPropertyEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.HumanProperty

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@Dao
interface HumanPropertyEntityDao {

    @Transaction
    @Query("SELECT * FROM human WHERE Id = :Id")
    fun getHumanByCurrentId(Id: Long) : HumanPropertyEntity

    @Transaction
    @Query("SELECT * FROM human")
    fun getListHuman(): List<HumanPropertyEntity>

    @Insert
    fun insert(humanPropertyEntity: HumanPropertyEntity?)

    @Update
    fun update(humanPropertyEntity: HumanPropertyEntity?)

    @Delete
    fun delete(humanPropertyEntity: HumanPropertyEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHumanProperty(humanPropertyEntity: HumanPropertyEntity?)

}