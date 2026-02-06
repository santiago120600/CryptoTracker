package io.github.santiago120600.cryptotracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import io.github.santiago120600.cryptotracker.data.local.entity.Commission
import io.github.santiago120600.cryptotracker.data.local.entity.CommissionWithTransactions

@Dao
interface CommissionDao {
    @Query("SELECT * FROM commission ORDER BY id ASC")
    suspend fun getCommissionList(): List<Commission>

    @Query("SELECT * FROM commission WHERE id = :id")
    suspend fun getCommissionById(id: Int): Commission

    @Insert
    suspend fun insertCommission(commission: Commission)

    @Update
    suspend fun updateCommission(commission: Commission)

    @Delete
    suspend fun deleteCommission(commission: Commission)

    @Transaction
    @Query("SELECT * FROM commission")
    suspend fun getCommissionWithTransactions(): List<CommissionWithTransactions>

}