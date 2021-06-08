package com.rsh_engineering.tkachenkoni.checkpressurelist.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.HumanPropertyEntity

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
data class HumanProperty(
    @Embedded
    var humanProperty: HumanPropertyEntity
){
    @Relation(parentColumn = "Id", entityColumn = "HumanId", entity = PressureItem::class)
    var pressureItems: List<PressureItem>? = null

    @Relation(parentColumn = "Id", entityColumn = "HumanId", entity = WeightItem::class)
    var weightItems: List<WeightItem>? = null
}