package com.hebaelsaid.cryptocurrencyapp.presentation.coin_detail

import com.hebaelsaid.cryptocurrencyapp.data.model.CoinDetail

data class CoinDetailsState(
    val isLoading:Boolean=false,
    val coinDetails: CoinDetail? = null,
    val error:String = ""
)
