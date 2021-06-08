package com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository

import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.WeightItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
interface WeightRepository {

    fun insertWeight(weightItemEntity: WeightItemEntity?)

    fun updateWeight(weightItemEntity: WeightItemEntity?)

    fun deleteWeight(weightItemEntity: WeightItemEntity?)

    fun insertWeighReplace(weightItemEntity: WeightItemEntity?)
}