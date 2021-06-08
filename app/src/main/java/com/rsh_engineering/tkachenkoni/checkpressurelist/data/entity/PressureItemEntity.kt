package com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
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
    @ColumnInfo(name = "PressureId")
    val id : Long,
    @ColumnInfo(name = "HumanId")
    val humanId : Long,
    @ColumnInfo(name = "High")
    val highPressure: Int,
    @ColumnInfo(name = "Low")
    val lowPressure: Int,
    @ColumnInfo(name = "Date")
    val dateMeasure: Long,
    @ColumnInfo(name = "Type")
    val typeMesurement: Int
) : Parcelable