package io.github.santiago120600.cryptotracker.data.repository
import io.github.santiago120600.cryptotracker.data.local.dao.CommissionDao
import io.github.santiago120600.cryptotracker.data.local.entity.Commission
import io.github.santiago120600.cryptotracker.data.local.entity.CommissionWithTransactions
import io.github.santiago120600.cryptotracker.domain.model.Commission as CommissionModel

class CommissionRepository(private val commissionDao: CommissionDao) {

    suspend fun getCommissionList(): List<CommissionModel> {
        return commissionDao.getCommissionList().map { it.toModel() }
    }

    suspend fun getCommissionById(id: Int): CommissionModel {
        return commissionDao.getCommissionById(id).toModel()
    }

    suspend fun insertCommission(commission: CommissionModel) {
        commissionDao.insertCommission(commission.toEntity())
    }

    suspend fun updateCommission(commission: CommissionModel) {
        commissionDao.updateCommission(commission.toEntity())
    }

    suspend fun deleteCommission(commission: CommissionModel) {
        commissionDao.deleteCommission(commission.toEntity())
    }

    suspend fun getCommissionWithTransactions(): List<CommissionWithTransactions> {
        return commissionDao.getCommissionWithTransactions()
    }

    fun CommissionModel.toEntity(): Commission {
        return Commission(
            id = id,
            amount = amount,
            currencyId = currencyId,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )
    }

    fun Commission.toModel(): CommissionModel {
        return CommissionModel(
            id = id,
            amount = amount,
            currencyId = currencyId,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )
    }
}