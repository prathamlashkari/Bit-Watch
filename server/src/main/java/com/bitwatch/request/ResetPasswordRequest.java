package com.bitwatch.request;

import lombok.Data;

@Data
public class ResetPasswordRequest {
  private String opt;
  private String password;
}
