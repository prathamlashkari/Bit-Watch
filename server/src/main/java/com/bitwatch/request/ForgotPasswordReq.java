package com.bitwatch.request;

import com.bitwatch.enums.VerificationType;

import lombok.Data;

@Data
public class ForgotPasswordReq {
  private String sendTo;
  private VerificationType verificationType;
}
