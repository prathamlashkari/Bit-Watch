package com.bitwatch.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bitwatch.enums.USER_ROLE;

import lombok.Data;

@Data
@Document(collection = "User")
public class UserModel {

  @Id
  private String id;
  private String fullName;
  private String email;
  private String password;
  private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
  private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

}
