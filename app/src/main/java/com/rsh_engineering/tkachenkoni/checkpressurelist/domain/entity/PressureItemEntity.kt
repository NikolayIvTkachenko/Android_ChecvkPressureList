package com.rsh_engineering.tkachenkoni.checkpressurelist.domain.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
@Entity(tableName = "pressure")
@Parcelize
data class PressureItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val highPressure: Int,
    val lowPressure: Int,
    val dateMeasure: Long,
    val typeMesurement: Int
) : Parcelable