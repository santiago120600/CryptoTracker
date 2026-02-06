package io.github.santiago120600.cryptotracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import io.github.santiago120600.cryptotracker.data.local.entity.Price
import io.github.santiago120600.cryptotracker.data.local.entity.PriceWithTransactions

@Dao
interface PriceDao {
    @Query("SELECT * FROM price ORDER BY id ASC")
    suspend fun getPriceList(): List<Price>

    @Query("SELECT * FROM price WHERE id = :id")
    suspend fun getPriceById(id: Int): Price

    @Insert
    suspend fun insertPrice(price: Price)

    @Update
    suspend fun updatePrice(price: Price)

    @Delete
    suspend fun deletePrice(price: Price)

    @Transaction
    @Query("SELECT * FROM price")
    suspend fun getPriceWithTransactions(): List<PriceWithTransactions>

}