package com.bitwatch.request;

import lombok.Data;

@Data
public class ForgotPasswordReq {

  private String sendTo;
  private String otp;
}
