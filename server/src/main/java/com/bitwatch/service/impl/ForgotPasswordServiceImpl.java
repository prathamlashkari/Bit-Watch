package com.bitwatch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.ForgotPassword;
import com.bitwatch.models.UserModel;
import com.bitwatch.repository.ForgotpasswordRepository;
import com.bitwatch.service.ForgotPasswordService;
import java.util.*;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

  @Autowired
  private ForgotpasswordRepository forgotpasswordRepository;

  @Override
  public ForgotPassword createToken(UserModel userModel, String otp, VerificationType verificationType,
      String sendTo) {
    ForgotPassword token = new ForgotPassword();
    token.setUserid(userModel.getId());
    token.setSendTo(sendTo);
    token.setVerificationType(verificationType);
    token.setOtp(otp);
    return forgotpasswordRepository.save(token);
  }

  @Override
  public ForgotPassword findById(String id) {
    Optional<ForgotPassword> tokeOptional = forgotpasswordRepository.findById(id);
    return tokeOptional.orElse(null);
  }

  @Override
  public ForgotPassword findByUser(String userId) {
    return forgotpasswordRepository.findByUserId(userId);
  }

  @Override
  public void deleteToken(ForgotPassword token) {
    forgotpasswordRepository.delete(token);
  }

}
