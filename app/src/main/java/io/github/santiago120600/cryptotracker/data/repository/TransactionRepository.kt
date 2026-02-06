package io.github.santiago120600.cryptotracker.data.repository

import androidx.room.Query
import io.github.santiago120600.cryptotracker.data.local.dao.TransactionDao
import io.github.santiago120600.cryptotracker.data.local.entity.Transaction
import io.github.santiago120600.cryptotracker.domain.model.Transaction as TransactionModel

class TransactionRepository(private val transactionDao: TransactionDao) {

    suspend fun getTransactionsList(): List<TransactionModel> {
        return transactionDao.getTransactionsList().map { it.toModel() }
    }

    suspend fun getTransactionById(id: Int): TransactionModel {
        return transactionDao.getTransactionById(id).toModel()
    }

    suspend fun insertTransaction(transaction: TransactionModel) {
        transactionDao.insertTransaction(transaction.toEntity())
    }

    suspend fun updateTransaction(transaction: TransactionModel) {
        transactionDao.updateTransaction(transaction.toEntity())
    }

    suspend fun deleteTransaction(transaction: TransactionModel) {
        transactionDao.deleteTransaction(transaction.toEntity())
    }

    fun TransactionModel.toEntity(): Transaction{
        return Transaction(
            id = id,
            date = date,
            platform = platform,
            type = type,
            amount = amount,
            priceId = priceId,
            currencyId = currencyId,
            commissionId = commissionId,
            exchangeRate = exchangeRate,
            notes = notes,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )
    }

    fun Transaction.toModel(): TransactionModel{
        return TransactionModel(
            id = id,
            date = date,
            platform = platform,
            type = type,
            amount = amount,
            priceId = priceId,
            currencyId = currencyId,
            commissionId = commissionId,
            exchangeRate = exchangeRate,
            notes = notes,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )

    }

}