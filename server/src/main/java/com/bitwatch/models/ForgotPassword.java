package com.bitwatch.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bitwatch.enums.VerificationType;

import lombok.Data;

@Data
@Document(collection = "ForgotPassword")
public class ForgotPassword {

  @Id
  private String id;
  private String userid;
  private VerificationType verificationType;
  private String sendTo
}
