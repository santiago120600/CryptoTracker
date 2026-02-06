package io.github.santiago120600.cryptotracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.github.santiago120600.cryptotracker.data.local.entity.Transaction
@Dao
interface TransactionDao {
    @Query("SELECT * FROM money_transaction ORDER BY id ASC")
    suspend fun getTransactionsList(): List<Transaction>

    @Query("SELECT * FROM money_transaction WHERE id = :id")
    suspend fun getTransactionById(id: Int): Transaction

    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}