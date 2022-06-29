package com.hebaelsaid.cryptocurrencyapp.presentation.coin_data_list

import com.hebaelsaid.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean=false,
    val coins: List<Coin> = emptyList(),
    val error:String = ""
)
