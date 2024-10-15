package com.bitwatch.service;

import java.util.List;

import com.bitwatch.models.Coin;

public interface CoinService {

  List<Coin> getCoinList(int page);

  String getMarketChart(String coinId, int days);

  String getCoinDetails(String coinId);

  Coin findById(String id);

  String searchCoin(String keyWord);

  String getTop50CoinsByMarketCapRank();

  String getTrendingCoins();
}
