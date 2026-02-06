package io.github.santiago120600.cryptotracker.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import io.github.santiago120600.cryptotracker.data.local.dao.*
import io.github.santiago120600.cryptotracker.data.local.entity.*

@Database(
    entities = [
        Transaction::class,
        Price::class,
        Currency::class,
        Commission::class],
    version = 1,
    exportSchema = false
)
abstract class TrackerDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun priceDao(): PriceDao
    abstract fun currencyDao(): CurrencyDao
    abstract fun commissionDao(): CommissionDao
}