package com.hebaelsaid.cryptocurrencyapp.data.repository

import com.hebaelsaid.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coin_detail.CoinDetailsResponseModel
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coins.CoinsDataResponseModel
import com.hebaelsaid.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinsRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinsDataResponseModel> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsResponseModel {
        return api.getCoinByID(coinId)
    }
}