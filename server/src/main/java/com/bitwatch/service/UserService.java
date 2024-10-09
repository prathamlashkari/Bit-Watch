package com.bitwatch.service;

import com.bitwatch.models.UserModel;

public interface UserService {

  public UserModel findUserProfileByJwt(String jwt);

  public UserModel findUserByEmail(String email);

  public UserModel findUserById(String id);

  public UserModel enalbeTwoFactorAuthentication(UserModel user);

  UserModel updatePassword(UserModel user, String newPassword);

}
