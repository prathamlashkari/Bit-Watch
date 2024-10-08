package com.bitwatch.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "TowFactorAuth")
public class TwoFactorOTP {

  @Id
  private String id;
  private String otp;
  private String userId;
  private String jwt;
}
