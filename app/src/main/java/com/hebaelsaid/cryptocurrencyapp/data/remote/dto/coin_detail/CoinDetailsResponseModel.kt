package com.hebaelsaid.cryptocurrencyapp.data.remote.dto.coin_detail

import com.hebaelsaid.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailsResponseModel(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
) {
    data class Links(
        val explorer: List<String>,
        val facebook: List<String>,
        val reddit: List<String>,
        val source_code: List<String>,
        val website: List<String>,
        val youtube: List<String>
    )

    data class LinksExtended(
        val stats: Stats,
        val type: String,
        val url: String
    ) {
        data class Stats(
            val contributors: Int,
            val followers: Int,
            val stars: Int,
            val subscribers: Int
        )
    }

    data class Tag(
        val coin_counter: Int,
        val ico_counter: Int,
        val id: String,
        val name: String
    )

    data class Team(
        val id: String,
        val name: String,
        val position: String
    )

    data class Whitepaper(
        val link: String,
        val thumbnail: String
    )
}

fun CoinDetailsResponseModel.toCoinDetail():CoinDetail{
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = is_active,
        tags = tags.map { it.name },
        team = team
    )
}