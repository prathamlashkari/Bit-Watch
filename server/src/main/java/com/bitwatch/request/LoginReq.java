package com.bitwatch.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginReq {
  private String email;
  private String password;
}
