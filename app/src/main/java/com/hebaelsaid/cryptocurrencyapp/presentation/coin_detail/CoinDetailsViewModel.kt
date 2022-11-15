package com.hebaelsaid.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hebaelsaid.cryptocurrencyapp.common.Constants
import com.hebaelsaid.cryptocurrencyapp.common.Resource
import com.hebaelsaid.cryptocurrencyapp.domain.use_case.get_coin_detail.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    stateHandle: SavedStateHandle
): ViewModel(){
    private val _state  = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        stateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinID ->
            getCoinDetails(coinID = coinID)
        }
    }
    private fun getCoinDetails(coinID:String){
        getCoinDetailsUseCase(coinId = coinID).onEach { resultState->
            when(resultState){
                is Resource.Success ->{
                    _state.value = CoinDetailsState(coinDetails= resultState.data)
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailsState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CoinDetailsState(error = resultState.message?: "un expected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}