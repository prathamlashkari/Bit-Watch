package com.bitwatch.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "TowFactorAuth")
public class TwoFactorAuthModel {

  private String id;
  private String opt;
  private String userId;
  private String jwt;
}
