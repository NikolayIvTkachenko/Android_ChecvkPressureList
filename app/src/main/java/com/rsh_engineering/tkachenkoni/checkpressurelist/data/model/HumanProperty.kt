package com.rsh_engineering.tkachenkoni.checkpressurelist.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.HumanPropertyEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.PressureItemEntity
import com.rsh_engineering.tkachenkoni.checkpressurelist.data.entity.WeightItemEntity

/**
 *
 * Created by Nikolay Tkachenko on 07, June, 2021
 *
 */
data class HumanProperty(
    @Embedded
    var humanProperty: HumanPropertyEntity
){
    @Relation(parentColumn = "Id", entityColumn = "HumanId", entity = PressureItemEntity::class)
    var pressureItems: List<PressureItem>? = null

    @Relation(parentColumn = "Id", entityColumn = "HumanId", entity = WeightItemEntity::class)
    var weightItems: List<WeightItem>? = null
}