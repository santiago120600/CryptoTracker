package io.github.santiago120600.cryptotracker.domain.model

data class Transaction(
    var id: Int,
    var date: String,
    var platform: String,
    var type: String,
    var amount: Double,
    var priceId: Int,
    var currencyId: Int,
    var commissionId: Int,
    var exchangeRate: Double,
    var notes: String,
    var createdDate: Long,
    var modifiedDate: Long
)
