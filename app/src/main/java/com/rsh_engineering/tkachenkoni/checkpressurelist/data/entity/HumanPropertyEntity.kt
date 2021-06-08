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
@Entity(tableName = "human")
@Parcelize
data class HumanPropertyEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val Id: Long,
    @ColumnInfo(name = "Name")
    val nameHuman: String,
    @ColumnInfo(name = "Family")
    val familyHuman: String,
    @ColumnInfo(name = "Age")
    val age: Int
) : Parcelable