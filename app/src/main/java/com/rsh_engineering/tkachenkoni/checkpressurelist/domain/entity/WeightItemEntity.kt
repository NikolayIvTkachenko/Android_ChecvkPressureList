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
@Entity(tableName = "weight")
@Parcelize
data class WeightItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val weigh: Double,
    val dateMeasure: Long
) : Parcelable