package io.github.santiago120600.cryptotracker.data.repository
import io.github.santiago120600.cryptotracker.data.local.dao.PriceDao
import io.github.santiago120600.cryptotracker.data.local.entity.Price
import io.github.santiago120600.cryptotracker.data.local.entity.PriceWithTransactions
import io.github.santiago120600.cryptotracker.domain.model.Price as PriceModel

class PriceRepository(private val priceDao: PriceDao) {

    suspend fun getPriceList(): List<PriceModel> {
        return priceDao.getPriceList().map { it.toModel() }
    }

    suspend fun getPriceById(id: Int): PriceModel {
        return priceDao.getPriceById(id).toModel()
    }

    suspend fun insertPrice(price: PriceModel) {
        priceDao.insertPrice(price.toEntity())
    }

    suspend fun updatePrice(price: PriceModel) {
        priceDao.updatePrice(price.toEntity())
    }

    suspend fun deletePrice(price: PriceModel) {
        priceDao.deletePrice(price.toEntity())
    }

    suspend fun getPriceWithTransactions(): List<PriceWithTransactions> {
        return priceDao.getPriceWithTransactions()
    }

    fun Price.toModel(): PriceModel {
        return PriceModel(
            id = id,
            price = price,
            currencyId = currencyId,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )
    }

    fun PriceModel.toEntity(): Price {
        return Price(
            id = id,
            price = price,
            currencyId = currencyId,
            createdDate = createdDate,
            modifiedDate = modifiedDate
        )
}
}