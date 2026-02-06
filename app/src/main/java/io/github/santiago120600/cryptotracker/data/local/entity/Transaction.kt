package io.github.santiago120600.cryptotracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "money_transaction")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "date") val date: String, //transaction date
    @ColumnInfo(name = "platform") val platform: String, //binance, coinbase, etc
    @ColumnInfo(name= "type") val type: String, //'buy' or 'sell' for easy filtering
    @ColumnInfo(name = "amount") val amount: Double, //amount of currency. For example, 0.1 BTC
    @ColumnInfo(name = "price_id") val priceId: Int, // Price 5000MXN, 300USD, etc
    @ColumnInfo(name = "currency_id") val currencyId: Int, // Currency MXN, USD, BTC
    @ColumnInfo(name = "commission_id") val commissionId: Int, // Commission 70MXN, 3USD, etc
    @ColumnInfo(name = "exchange_rate") val exchangeRate: Double, // Example 20000MXN/BTC: will be a calculated field
    @ColumnInfo(name="notes") val notes: String,
    @ColumnInfo(name = "created_date") val createdDate: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "modified_date") val modifiedDate: Long = System.currentTimeMillis(),
)