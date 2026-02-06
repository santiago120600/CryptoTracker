package io.github.santiago120600.cryptotracker.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CommissionWithTransactions(
    @Embedded val commission: Commission,
    @Relation(
        parentColumn = "id",
        entityColumn = "commission_id"
    )
    val transactions: List<Transaction>
)
