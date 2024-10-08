package com.bitwatch.request;

import com.bitwatch.models.TwoFactorAuth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginReq {
  private String email;
  private String password;
  private TwoFactorAuth twoFactorAuth;

}
