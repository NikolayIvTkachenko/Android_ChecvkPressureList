package com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository

import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.HumanPropertyEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.HumanProperty

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
interface HumanRepository {

    fun getHumanByCurrentId(Id: Long) : HumanProperty

    fun getListHuman(): List<HumanProperty>

    fun insertHuman(humanPropertyEntity: HumanPropertyEntity?)

    fun updateHuman(humanPropertyEntity: HumanPropertyEntity?)

    fun deleteHuman(humanPropertyEntity: HumanPropertyEntity?)

    fun insertHumanReplace(humanPropertyEntity: HumanPropertyEntity?)

}