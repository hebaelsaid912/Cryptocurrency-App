package com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coins

import com.hebaelsaid.cryptocurrencyapp.domain.model.Coin

data class CoinsDataResponseModel(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinsDataResponseModel.toCoin(): Coin{
    return Coin(
        coin_id = id,
        isActive = is_active,
        isNew = is_new,
        name = name,
        symbol = symbol
    )
}