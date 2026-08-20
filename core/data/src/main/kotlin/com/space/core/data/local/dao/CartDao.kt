package com.space.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.space.core.data.local.entity.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items WHERE id = :id")
    suspend fun getCartItemById(id: Int): CartEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(item: CartEntity)

    @Query("DELETE FROM cart_items WHERE id = :id")
    suspend fun deleteCartItemById(id: Int)

    @Query("SELECT * FROM cart_items ORDER BY addedAt DESC")
    fun getAllCartItems(): Flow<List<CartEntity>>

    @Query("UPDATE cart_items SET quantity = quantity + 1 WHERE id = :id AND quantity < 10")
    suspend fun increment(id: Int)

    @Query("UPDATE cart_items SET quantity = quantity - 1 WHERE id = :id AND quantity > 1")
    suspend fun decrement(id: Int)

    @Query("SELECT COUNT(*) FROM cart_items")
    fun getCartItemsCount(): Flow<Int>

    @Query("DELETE FROM cart_items")
    suspend fun clearCart()
}