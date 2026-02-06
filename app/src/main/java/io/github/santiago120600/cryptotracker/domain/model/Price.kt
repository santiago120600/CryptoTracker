package io.github.santiago120600.cryptotracker.domain.model

data class Price(
    val id: Int,
    val price: Double,
    val currencyId: Int,
    val createdDate: Long,
    val modifiedDate: Long
)
