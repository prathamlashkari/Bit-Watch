package com.bitwatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bitwatch.models.TwoFactorOTP;

@Repository
public interface TwoFactorOtpRepository extends MongoRepository<TwoFactorOTP, String> {

  TwoFactorOTP findByUserId(String userId);

}
