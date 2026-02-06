package io.github.santiago120600.cryptotracker.data.repository

import io.github.santiago120600.cryptotracker.data.local.dao.CurrencyDao
import io.github.santiago120600.cryptotracker.data.local.entity.Currency
import io.github.santiago120600.cryptotracker.data.local.entity.CurrencyWithCommissions
import io.github.santiago120600.cryptotracker.data.local.entity.CurrencyWithPrices
import io.github.santiago120600.cryptotracker.data.local.entity.CurrencyWithTransactions
import io.github.santiago120600.cryptotracker.domain.model.Currency as CurrencyModel


class CurrencyRepository(private val currencyDao: CurrencyDao) {

    suspend fun getCurrencyList(): List<CurrencyModel> {
        return currencyDao.getCurrencyList().map { it.toModel() }
    }

    suspend fun getCurrencyById(id: Int): CurrencyModel {
        return currencyDao.getCurrencyById(id).toModel()
    }

    suspend fun insertCurrency(currency: CurrencyModel) {
        currencyDao.insertCurrency(currency.toEntity())
    }

    suspend fun updateCurrency(currency: CurrencyModel) {
        currencyDao.updateCurrency(currency.toEntity())
    }

    suspend fun deleteCurrency(currency: CurrencyModel) {
        currencyDao.deleteCurrency(currency.toEntity())
    }

    suspend fun getCurrencyWithPrices(): List<CurrencyWithPrices> {
        return currencyDao.getCurrencyWithPrices()
    }

    suspend fun getCurrencyWithCommissions(): List<CurrencyWithCommissions> {
        return currencyDao.getCurrencyWithCommissions()
    }

    suspend fun getCurrencyWithTransactions(): List<CurrencyWithTransactions> {
        return currencyDao.getCurrencyTransactions()
    }

    fun CurrencyModel.toEntity(): Currency{
        return Currency(
            id = id,
            name = name,
            symbol = symbol,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )
    }

    fun Currency.toModel(): CurrencyModel{
        return CurrencyModel(
            id = id,
            name = name,
            symbol = symbol,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )
    }
}