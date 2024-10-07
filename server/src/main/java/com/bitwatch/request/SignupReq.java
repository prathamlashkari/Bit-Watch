package com.bitwatch.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupReq {

  private String fullName;
  private String email;
  private String password;
}
