package com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository

import androidx.lifecycle.LiveData
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.HumanPropertyEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.model.HumanProperty
import io.reactivex.Flowable
import io.reactivex.Single

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
interface HumanRepository {

    fun getHumanByCurrentIdGeneral(Id: Long) : HumanProperty

    fun getListHumanGeneral(): List<HumanPropertyEntity>

    fun getHumanByCurrentIdGeneralSingle(Id: Long) :  Flowable<HumanProperty>

    fun getListHumanGeneralSingle(): Flowable<List<HumanPropertyEntity>>

    fun getHumanByCurrentIdGeneralLiveData(Id: Long) : LiveData<HumanProperty>

    fun getListHumanGeneralLiveData(): LiveData<List<HumanPropertyEntity>>

    fun getHumanByCurrentId(Id: Long) : HumanPropertyEntity

    fun getListHuman(): List<HumanPropertyEntity>

    fun insertHuman(humanPropertyEntity: HumanPropertyEntity?)

    fun updateHuman(humanPropertyEntity: HumanPropertyEntity?)

    fun deleteHuman(humanPropertyEntity: HumanPropertyEntity?)

    fun insertHumanReplace(humanPropertyEntity: HumanPropertyEntity?)

}