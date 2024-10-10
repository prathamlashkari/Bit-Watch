package com.bitwatch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Forgotpassword extends MongoRepository<Forgotpassword, String> {

}
