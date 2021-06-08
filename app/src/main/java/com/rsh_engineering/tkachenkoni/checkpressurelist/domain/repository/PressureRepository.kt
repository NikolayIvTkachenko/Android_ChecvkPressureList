package com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository

import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.PressureItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.PressureItem

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
interface PressureRepository {

    fun getPressureItemByCurrentId(Id: Long) : PressureItem

    fun getListPressureItem(): List<PressureItem>

    fun insert(pressureItemEntity: PressureItemEntity?)

    fun update(pressureItemEntity: PressureItemEntity?)

    fun delete(pressureItemEntity: PressureItemEntity?)

    fun insertPressureItemEntity(pressureItemEntity: PressureItemEntity?)

}