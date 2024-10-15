package com.bitwatch.models;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Coin")
public class Coin {

  @Id
  private String id;
  private String symbol;
  private String name;
  private String image;
  private double currentPrice;
  private long marketCap;
  private int marketCapRank;
  private long fullDilutedValutation;
  private long totalVolume;
  private double high24;
  private double low24;
  private double priceChange24h;
  private double priceChangePercent24h;
  private long marketCapChange24h;
  private double marketCapChangePercent24h;
  private long circulationSupply;
  private long totalSupply;
  private long maxSupply;
  private double ath;
  private double athChangerPercentage;
  private Date athDate;
  private double atl;
  private double atlChangePercentage;
  private Date atlDate;
  private String roi;
  private Date lastUpdated;

}
