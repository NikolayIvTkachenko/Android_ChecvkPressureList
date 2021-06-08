package com.rsh_engineering.tkachenkoni.checkpressurelist.data.repositoryImpl

import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.HumanPropertyEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.HumanProperty
import com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository.HumanRepository
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.HumanPropertyEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.PressureItemEntityDao
import javax.inject.Inject

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
class HumanRepositoryImpl @Inject constructor(val humanDao: HumanPropertyEntityDao): HumanRepository {

    override fun getHumanByCurrentId(Id: Long): HumanPropertyEntity {
        TODO("Not yet implemented")
    }

    override fun getListHuman(): List<HumanPropertyEntity> {
        TODO("Not yet implemented")
    }

    override fun insertHuman(humanPropertyEntity: HumanPropertyEntity?) {
        TODO("Not yet implemented")
    }

    override fun updateHuman(humanPropertyEntity: HumanPropertyEntity?) {
        TODO("Not yet implemented")
    }

    override fun deleteHuman(humanPropertyEntity: HumanPropertyEntity?) {
        TODO("Not yet implemented")
    }

    override fun insertHumanReplace(humanPropertyEntity: HumanPropertyEntity?) {
        TODO("Not yet implemented")
    }

}