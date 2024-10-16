package com.bitwatch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwatch.models.Coin;
import com.bitwatch.repository.CoinRepository;
import com.bitwatch.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService {

  @Autowired
  private CoinRepository coinRepository;

  @Override
  public List<Coin> getCoinList(int page) {

    throw new UnsupportedOperationException("Unimplemented method 'getCoinList'");
  }

  @Override
  public String getMarketChart(String coinId, int days) {
    throw new UnsupportedOperationException("Unimplemented method 'getMarketChart'");
  }

  @Override
  public String getCoinDetails(String coinId) {
    throw new UnsupportedOperationException("Unimplemented method 'getCoinDetails'");
  }

  @Override
  public Coin findById(String id) {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public String searchCoin(String keyWord) {
    throw new UnsupportedOperationException("Unimplemented method 'searchCoin'");
  }

  @Override
  public String getTop50CoinsByMarketCapRank() {
    throw new UnsupportedOperationException("Unimplemented method 'getTop50CoinsByMarketCapRank'");
  }

  @Override
  public String getTrendingCoins() {
    throw new UnsupportedOperationException("Unimplemented method 'getTrendingCoins'");
  }

}
