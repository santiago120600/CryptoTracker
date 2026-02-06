package io.github.santiago120600.cryptotracker.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PriceWithTransactions(
    @Embedded val price: Price,
    @Relation(
        parentColumn = "id",
        entityColumn = "price_id"
    )
    val transactions: List<Transaction>
)
