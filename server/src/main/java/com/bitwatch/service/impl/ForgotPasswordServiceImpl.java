package com.bitwatch.service.impl;

import org.springframework.stereotype.Service;

import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.ForgotPassword;
import com.bitwatch.models.UserModel;
import com.bitwatch.service.ForgotPasswordService;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

  @Override
  public ForgotPassword createToken(UserModel userModel, String id, String otp, VerificationType verificationType,
      String sendTo) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createToken'");
  }

  @Override
  public ForgotPassword findById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public ForgotPassword findByUser(String userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByUser'");
  }

  @Override
  public void deleteToken(ForgotPassword token) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteToken'");
  }

}
