package com.rsh_engineering.tkachenkoni.checkpressurelist.data.model

import androidx.room.Embedded
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.WeightItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
data class WeightItem(
    @Embedded
    val weight: WeightItemEntity
)