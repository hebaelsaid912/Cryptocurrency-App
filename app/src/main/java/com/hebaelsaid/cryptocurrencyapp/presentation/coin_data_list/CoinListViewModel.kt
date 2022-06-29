package com.hebaelsaid.cryptocurrencyapp.presentation.coin_data_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hebaelsaid.cryptocurrencyapp.common.Resource
import com.hebaelsaid.cryptocurrencyapp.domain.use_case.get_coin_data_list.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel(){
    private val _state  = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }
    private fun getCoins(){
        getCoinsUseCase().onEach { resultState->
            when(resultState){
                is Resource.Success ->{
                    _state.value = CoinListState(coins= resultState.data ?: emptyList())
                }
                is Resource.Loading ->{
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CoinListState(error = resultState.message?: "un expected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}