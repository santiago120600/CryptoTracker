package io.github.santiago120600.cryptotracker.ui.currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.santiago120600.cryptotracker.data.repository.CurrencyRepository
import io.github.santiago120600.cryptotracker.domain.model.Currency
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    private val _currencies = MutableStateFlow<List<Currency>>(emptyList())
    val currencies: StateFlow<List<Currency>> = _currencies.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadCurrencies()
    }

    fun loadCurrencies() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val currencyList = currencyRepository.getCurrencyList()
                _currencies.value = currencyList
            } catch (e: Exception) {
                // Handle error (you could add an error state)
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}