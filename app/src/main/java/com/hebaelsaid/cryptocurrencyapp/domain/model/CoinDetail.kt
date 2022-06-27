package com.hebaelsaid.cryptocurrencyapp.domain.model

import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coin_detail.CoinDetailsResponseModel

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<CoinDetailsResponseModel.Team>
)
