package com.rsh_engineering.tkachenkoni.checkpressurelist.data.repositoryImpl

import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.WeightItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.domain.repository.WeightRepository
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.PressureItemEntityDao
import com.rsh_engineering.tkachenkoni.checkpressurelist.presentation.db.dao.WeightItemEntityDao
import javax.inject.Inject

/**
 *
 * Created by Nikolay Tkachenko on 08, June, 2021
 *
 */
class WeightRepositoryImpl @Inject constructor(val weightDao: WeightItemEntityDao): WeightRepository {

    override fun insertWeight(weightItemEntity: WeightItemEntity?) {
        TODO("Not yet implemented")
    }

    override fun updateWeight(weightItemEntity: WeightItemEntity?) {
        TODO("Not yet implemented")
    }

    override fun deleteWeight(weightItemEntity: WeightItemEntity?) {
        TODO("Not yet implemented")
    }

    override fun insertWeighReplace(weightItemEntity: WeightItemEntity?) {
        TODO("Not yet implemented")
    }

}