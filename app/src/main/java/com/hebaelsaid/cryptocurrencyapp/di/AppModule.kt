package com.hebaelsaid.cryptocurrencyapp.di

import com.hebaelsaid.cryptocurrencyapp.common.Constants
import com.hebaelsaid.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.hebaelsaid.cryptocurrencyapp.data.repository.CoinsRepositoryImp
import com.hebaelsaid.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinsRepositoryImp(api = api)
    }
}