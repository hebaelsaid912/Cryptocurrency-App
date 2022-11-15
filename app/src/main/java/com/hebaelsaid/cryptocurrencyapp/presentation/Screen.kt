package com.hebaelsaid.cryptocurrencyapp.presentation

sealed class Screen(val route:String){
    object CoinListScreen:Screen("coin_list_screen")
    object CoinDetailsScreen:Screen("coin_details_screen")
}
