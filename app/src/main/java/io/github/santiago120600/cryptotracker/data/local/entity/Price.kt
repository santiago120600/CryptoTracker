package io.github.santiago120600.cryptotracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "price")
data class Price(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "currency_id") val currencyId: Int,
    @ColumnInfo(name = "created_date") val createdDate: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "modified_date") val modifiedDate: Long = System.currentTimeMillis(),
)
