package com.hebaelsaid.cryptocurrencyapp.data.model

data class Coin(
    val coin_id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
