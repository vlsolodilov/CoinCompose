package com.solodilov.coin.screen.coin_detail.business

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solodilov.domain.entity.CoinDetail
import com.solodilov.domain.entity.Currency
import com.solodilov.domain.usecase.GetCoinDetailUseCase
import com.solodilov.domain.usecase.GetCoinListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoinDetailsViewModel(
    private val coinId: String,
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CoinDetailScreenState>(CoinDetailScreenState.Loading)
    val uiState: StateFlow<CoinDetailScreenState> = _uiState

    init {
        loadCoinDetails()
    }

    fun loadCoinDetails() {
        _uiState.value = CoinDetailScreenState.Loading
        viewModelScope.launch {
            _uiState.value = getCoinDetailUseCase(coinId).fold(
                onSuccess = { details ->
                    Log.e("TAG", "loadCoinList: onSuccess")
                    CoinDetailScreenState.Content(details)
                },
                onFailure = {
                    Log.e("TAG", "loadCoinList: ${it.message}")
                    CoinDetailScreenState.Error
                }
            )
        }
    }

}