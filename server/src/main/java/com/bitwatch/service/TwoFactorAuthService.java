package com.bitwatch.service;

import com.bitwatch.models.TwoFactorOTP;
import com.bitwatch.models.UserModel;

public interface TwoFactorAuthService {
  TwoFactorOTP createTwoFactorOtp(UserModel user, String otp, String jwt);

  TwoFactorOTP findByUserId(String userId);

  TwoFactorOTP findById(String id);

  boolean verfiyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp);

  void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);
}
