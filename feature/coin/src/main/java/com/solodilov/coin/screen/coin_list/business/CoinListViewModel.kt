package com.solodilov.coin.screen.coin_list.business

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solodilov.domain.entity.Currency
import com.solodilov.domain.usecase.GetCoinListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val getCoinListUseCase: GetCoinListUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CoinListScreenState>(CoinListScreenState.Loading)
    val uiState: StateFlow<CoinListScreenState> = _uiState

    private val _currency = MutableStateFlow<Currency>(Currency.USD)
    val currency: StateFlow<Currency> = _currency

    init {
        loadCoinList()
    }

    fun loadCoinList() {
        _uiState.value = CoinListScreenState.Loading
        viewModelScope.launch {
            _uiState.value = getCoinListUseCase(_currency.value).fold(
                onSuccess = { coinList ->
                    Log.e("TAG", "loadCoinList: onSuccess", )
                    CoinListScreenState.Content(coinList)
                },
                onFailure = {
                    Log.e("TAG", "loadCoinList: ${it.message}", )
                    CoinListScreenState.Error
                }
            )
        }
    }

    fun onSelectedCurrency(currency: Currency) {
        if (_currency.value != currency) {
            _currency.value = currency
            loadCoinList()
        }
    }

}