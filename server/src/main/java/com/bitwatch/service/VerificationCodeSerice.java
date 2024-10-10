package com.bitwatch.service;

import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.UserModel;
import com.bitwatch.models.VerificationCode;

public interface VerificationCodeSerice {
  VerificationCode sendVerificationCode(UserModel userModel, VerificationType verificationType);

  VerificationCode getVerificationCodeById(String id) throws Exception;

  VerificationCode getvVerificationCodeByUserId(String userId);

  void deleteVerificationCodeById(VerificationCode verificationCode);
}
