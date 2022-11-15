package com.hebaelsaid.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hebaelsaid.cryptocurrencyapp.presentation.coin_data_list.component.CoinListScreen
import com.hebaelsaid.cryptocurrencyapp.presentation.coin_detail.component.CoinDetailsScreen
import com.hebaelsaid.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route ){
                        composable(route =  Screen.CoinListScreen.route){
                            CoinListScreen(navController = navController)
                        }
                        composable(route =  Screen.CoinDetailsScreen.route+"/{coinId}"){
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}

