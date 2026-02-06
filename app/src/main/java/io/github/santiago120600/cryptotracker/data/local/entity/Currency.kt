package io.github.santiago120600.cryptotracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String, // Name of the currency: Bitcoin, Ethereum, USD, etc.
    @ColumnInfo(name = "symbol") val symbol: String, // Symbol of the currency: BTC, ETH, USD, etc.
    @ColumnInfo(name = "created_date") val createdDate: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "modified_date") val modifiedDate: Long = System.currentTimeMillis()
)
