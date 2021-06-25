package com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Nikolay Tkachenko on 24, June, 2021
 *
 */
@Entity(tableName = "temperature")
@Parcelize
class TemperatureItemEntity(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "Id")
    val Id : Long,
    @NonNull
    @ColumnInfo(name = "HumanId")
    val humanId : Long,
    @ColumnInfo(name = "Temperature")
    val temper: Double,
    @ColumnInfo(name = "Date")
    val dateMeasure: Long
) : Parcelable