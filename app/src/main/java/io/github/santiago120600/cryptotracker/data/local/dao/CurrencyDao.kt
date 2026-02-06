package io.github.santiago120600.cryptotracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import io.github.santiago120600.cryptotracker.data.local.entity.Currency
import io.github.santiago120600.cryptotracker.data.local.entity.CurrencyWithCommissions
import io.github.santiago120600.cryptotracker.data.local.entity.CurrencyWithPrices
import io.github.santiago120600.cryptotracker.data.local.entity.CurrencyWithTransactions

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currency ORDER BY id ASC")
    suspend fun getCurrencyList(): List<Currency>

    @Query("SELECT * FROM currency WHERE id = :id")
    suspend fun getCurrencyById(id: Int): Currency

    @Insert
    suspend fun insertCurrency(currency: Currency)

    @Update
    suspend fun updateCurrency(currency: Currency)

    @Delete
    suspend fun deleteCurrency(currency: Currency)

    @Transaction
    @Query("SELECT * FROM currency")
    suspend fun getCurrencyWithPrices(): List<CurrencyWithPrices>

    @Transaction
    @Query("SELECT * FROM currency")
    suspend fun getCurrencyWithCommissions(): List<CurrencyWithCommissions>

    @Transaction
    @Query("SELECT * FROM currency")
    suspend fun getCurrencyTransactions(): List<CurrencyWithTransactions>
}