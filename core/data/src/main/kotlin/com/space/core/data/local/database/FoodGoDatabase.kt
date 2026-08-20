package com.space.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.core.data.local.dao.CartDao
import com.space.core.data.local.entity.CartEntity

@Database(
    entities = [CartEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FoodGoDatabase : RoomDatabase() {
    abstract val cartDao: CartDao
}