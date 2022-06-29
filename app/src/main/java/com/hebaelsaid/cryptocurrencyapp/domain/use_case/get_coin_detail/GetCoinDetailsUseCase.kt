package com.hebaelsaid.cryptocurrencyapp.domain.use_case.get_coin_detail

import com.hebaelsaid.cryptocurrencyapp.common.Resource
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coin_detail.toCoinDetail
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coins.toCoin
import com.hebaelsaid.cryptocurrencyapp.domain.model.Coin
import com.hebaelsaid.cryptocurrencyapp.domain.model.CoinDetail
import com.hebaelsaid.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId:String) = flow<Resource<CoinDetail>> {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetails = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetails))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Please check your internet connection"))
        }
    }

}