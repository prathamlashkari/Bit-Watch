package com.bitwatch.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bitwatch.enums.VerificationType;

import lombok.Data;

@Data
@Document(collection = "VerificationCode")
public class VerificationCode {

  @Id
  private String id;
  private String otp;
  private String userId;
  private String mobile;
  private String email;
  private VerificationType verificationType;
}
