package com.rsh_engineering.tkachenkoni.checkpressurelist.data.repositoryImpl

import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.PressureItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.PressureItem
import com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository.PressureRepository
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.PressureItemEntityDao
import javax.inject.Inject

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
class PressureRepositoryImpl @Inject constructor(val pressureDao: PressureItemEntityDao) : PressureRepository {

    override fun getPressureItemByCurrentId(Id: Long): PressureItem {
        TODO("Not yet implemented")
    }

    override fun getListPressureItem(): List<PressureItem> {
        TODO("Not yet implemented")
    }

    override fun insert(pressureItemEntity: PressureItemEntity?) {
        TODO("Not yet implemented")
    }

    override fun update(pressureItemEntity: PressureItemEntity?) {
        TODO("Not yet implemented")
    }

    override fun delete(pressureItemEntity: PressureItemEntity?) {
        TODO("Not yet implemented")
    }

    override fun insertPressureItemEntity(pressureItemEntity: PressureItemEntity?) {
        TODO("Not yet implemented")
    }
}