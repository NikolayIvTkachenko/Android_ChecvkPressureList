package com.rsh_engineering.tkachenkoni.checkpressurelist.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.room.Query
import androidx.room.Transaction
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.HumanPropertyEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.HumanProperty
import com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository.HumanRepository
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.HumanPropertyEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.PressureItemEntityDao
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
class HumanRepositoryImpl @Inject constructor(val humanDao: HumanPropertyEntityDao): HumanRepository {

    override fun getHumanByCurrentIdGeneral(Id: Long): HumanProperty {
        return humanDao.getHumanByCurrentIdGeneral(Id)
    }

    override fun getListHumanGeneral(): List<HumanPropertyEntity> {
        return humanDao.getListHumanGeneral()
    }

    override fun getHumanByCurrentIdGeneralSingle(Id: Long): Flowable<HumanProperty> {
        return humanDao.getHumanByCurrentIdGeneralSingle(Id)
    }

    override fun getListHumanGeneralSingle():  Flowable<List<HumanPropertyEntity>> {
        return humanDao.getListHumanGeneralSingle()
    }

    override fun getHumanByCurrentIdGeneralLiveData(Id: Long): LiveData<HumanProperty> {
        return humanDao.getHumanByCurrentIdGeneralLiveData(Id)
    }

    override fun getListHumanGeneralLiveData(): LiveData<List<HumanPropertyEntity>> {
        return humanDao.getListHumanGeneralLiveData()
    }


    override fun getHumanByCurrentId(Id: Long): HumanPropertyEntity {
        return humanDao.getHumanByCurrentId(Id)
    }

    override fun getListHuman(): List<HumanPropertyEntity> {
        return humanDao.getListHuman()
    }

    override fun insertHuman(humanPropertyEntity: HumanPropertyEntity?) {
        humanDao.insert(humanPropertyEntity)
    }

    override fun updateHuman(humanPropertyEntity: HumanPropertyEntity?) {
        humanDao.update(humanPropertyEntity)
    }

    override fun deleteHuman(humanPropertyEntity: HumanPropertyEntity?) {
        humanDao.delete(humanPropertyEntity)
    }

    override fun insertHumanReplace(humanPropertyEntity: HumanPropertyEntity?) {
        humanDao.insertHumanProperty(humanPropertyEntity)
    }

}