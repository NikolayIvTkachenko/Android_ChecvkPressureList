package com.rsh_engineering.tkachenkoni.checkpressurelist.data.model

import androidx.room.Embedded
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.TemperatureItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.WeightItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 24, June, 2021
 *
 */
data class TemperatureItem(
    @Embedded
    val temperature: TemperatureItemEntity
)