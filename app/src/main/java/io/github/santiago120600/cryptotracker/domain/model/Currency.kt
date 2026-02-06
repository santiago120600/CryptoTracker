package io.github.santiago120600.cryptotracker.domain.model

data class Currency(
    var id: Int,
    var name: String,
    var symbol: String,
    var createdDate: Long,
    var modifiedDate: Long
)
