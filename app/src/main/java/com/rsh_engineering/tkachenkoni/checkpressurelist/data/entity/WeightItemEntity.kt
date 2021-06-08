package com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
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
    @NonNull
    @ColumnInfo(name = "Id")
    val Id : Long,
    @NonNull
    @ColumnInfo(name = "HumanId")
    val humanId : Long,
    @ColumnInfo(name = "Weight")
    val weigh: Double,
    @ColumnInfo(name = "Date")
    val dateMeasure: Long
) : Parcelable