package com.rsh_engineering.tkachenkoni.checkpressurelist.data.model

import androidx.room.Embedded
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.PressureItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
data class PressureItem(
    @Embedded
    val pressure: PressureItemEntity
)