package com.bitwatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bitwatch.models.VerificationCode;

@Repository
public interface VerificationCodeRepository extends MongoRepository<VerificationCode, String> {
  public VerificationCode findByUserId(String userId);
}
