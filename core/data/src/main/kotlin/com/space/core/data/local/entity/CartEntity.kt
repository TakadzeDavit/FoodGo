package com.space.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val price: Double,
    val imageResId: Int,
    val quantity: Int = 1,
    val addedAt: Long = System.currentTimeMillis()
)