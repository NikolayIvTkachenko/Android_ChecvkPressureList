package com.rsh_engineering.tkachenkoni.checkpressurelist.data.model

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
data class PressureItem(
    val highPressure: Int,
    val lowPressure: Int,
    val dateMeasure: Long,
    val typeMesurement: Int
)