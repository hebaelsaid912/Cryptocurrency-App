package com.hebaelsaid.cryptocurrencyapp.domain.use_case.get_coin_data_list

import com.hebaelsaid.cryptocurrencyapp.common.Resource
import com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coins.toCoin
import com.hebaelsaid.cryptocurrencyapp.domain.model.Coin
import com.hebaelsaid.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke() = flow<Resource<List<Coin>>> {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coin = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Please check your internet connection"))
        }
    }

}