package com.bitwatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bitwatch.models.Coin;

@Repository
public interface CoinRepository extends MongoRepository<Coin, String> {

}
