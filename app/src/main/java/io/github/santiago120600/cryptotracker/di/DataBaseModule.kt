package io.github.santiago120600.cryptotracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.santiago120600.cryptotracker.data.local.dao.*
import io.github.santiago120600.cryptotracker.data.local.database.TrackerDatabase
import io.github.santiago120600.cryptotracker.data.repository.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TrackerDatabase {
        return Room.databaseBuilder(
            context,
            TrackerDatabase::class.java,
            "crypto_tracker_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCurrencyDao(database: TrackerDatabase): CurrencyDao = database.currencyDao()

    @Provides
    @Singleton
    fun provideTransactionDao(database: TrackerDatabase): TransactionDao = database.transactionDao()

    @Provides
    @Singleton
    fun providePriceDao(database: TrackerDatabase): PriceDao = database.priceDao()

    @Provides
    @Singleton
    fun provideCommissionDao(database: TrackerDatabase): CommissionDao = database.commissionDao()

    @Provides
    @Singleton
    fun provideCurrencyRepository(dao: CurrencyDao): CurrencyRepository = CurrencyRepository(dao)

    @Provides
    @Singleton
    fun provideTransactionRepository(dao: TransactionDao): TransactionRepository = TransactionRepository(dao)

    @Provides
    @Singleton
    fun providePriceRepository(dao: PriceDao): PriceRepository = PriceRepository(dao)

    @Provides
    @Singleton
    fun provideCommissionRepository(dao: CommissionDao): CommissionRepository = CommissionRepository(dao)
}