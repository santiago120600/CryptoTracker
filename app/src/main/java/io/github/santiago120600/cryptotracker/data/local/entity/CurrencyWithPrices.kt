package io.github.santiago120600.cryptotracker.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CurrencyWithPrices(
    @Embedded val currency: Currency,
    @Relation(
        parentColumn = "id",
        entityColumn = "currency_id"
    )
    val prices: List<Price>
)
