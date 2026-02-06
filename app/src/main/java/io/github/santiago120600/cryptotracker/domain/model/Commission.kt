package io.github.santiago120600.cryptotracker.domain.model

data class Commission(
    var id: Int,
    var amount: Double,
    var currencyId: Int,
    var createdDate: Long,
    var modifiedDate: Long
)
