package com.hebaelsaid.cryptocurrencyapp.data.remote

import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coin_detail.CoinDetailsResponseModel
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coins.CoinsDataResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinsDataResponseModel>

    @GET("/v1/coins/{coinID}")
    suspend fun getCoinByID(
        @Path("coinID") coinID: String
    ): CoinDetailsResponseModel

}