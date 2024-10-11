package com.bitwatch.service;

import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.ForgotPassword;
import com.bitwatch.models.UserModel;

public interface ForgotPasswordService {

  ForgotPassword createToken(UserModel userModel, String otp, VerificationType verificationType,
      String sendTo);

  ForgotPassword findById(String id);

  ForgotPassword findByUser(String userId);

  void deleteToken(ForgotPassword token);

}
