package com.bitwatch.service;

import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.UserModel;

public interface UserService {

  public UserModel findUserProfileByJwt(String jwt) throws Exception;

  public UserModel findUserByEmail(String email) throws Exception;

  public UserModel findUserById(String id) throws Exception;

  public UserModel enalbeTwoFactorAuthentication(VerificationType verificationType, UserModel user) throws Exception;

  UserModel updatePassword(UserModel user, String newPassword) throws Exception;

}
