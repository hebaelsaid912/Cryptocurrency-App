package com.hebaelsaid.cryptocurrencyapp.domain.repository

import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coin_detail.CoinDetailsResponseModel
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coins.CoinsDataResponseModel

interface CoinRepository {
    suspend fun getCoins():List<CoinsDataResponseModel>
    suspend fun getCoinById(coinId:String):CoinDetailsResponseModel
}