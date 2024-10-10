package com.bitwatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bitwatch.models.ForgotPassword;

@Repository
public interface ForgotpasswordRepository extends MongoRepository<ForgotPassword, String> {

}
