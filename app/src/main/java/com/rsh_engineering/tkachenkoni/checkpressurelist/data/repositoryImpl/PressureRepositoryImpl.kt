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

    override fun getPressureItemByCurrentId(Id: Long): PressureItemEntity {
        return pressureDao.getPressureItemByCurrentId(Id)
    }

    override fun getListPressureItem(): List<PressureItemEntity> {
        return pressureDao.getListPressureItem()
    }

    override fun insert(pressureItemEntity: PressureItemEntity?) {
        pressureDao.insert(pressureItemEntity)
    }

    override fun update(pressureItemEntity: PressureItemEntity?) {
        pressureDao.update(pressureItemEntity)
    }

    override fun delete(pressureItemEntity: PressureItemEntity?) {
        pressureDao.delete(pressureItemEntity)
    }

    override fun insertPressureItemEntity(pressureItemEntity: PressureItemEntity?) {
        pressureDao.insertPressureItemEntity(pressureItemEntity)
    }
}