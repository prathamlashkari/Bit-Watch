package com.bitwatch.response;

import com.bitwatch.enums.USER_ROLE;

import lombok.Data;

@Data
public class AuthResponse {

  private String jwt;
  private String msg;
  private boolean status;
  private boolean isTwoFactorAuthEnabled;
  private String session;
  private USER_ROLE role;
}
