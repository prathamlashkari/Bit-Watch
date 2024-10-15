package com.bitwatch.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.UserModel;
import com.bitwatch.models.VerificationCode;
import com.bitwatch.repository.VerificationCodeRepository;
import com.bitwatch.service.VerificationCodeSerice;
import com.bitwatch.utils.OtpUtils;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeSerice {

  @Autowired
  private VerificationCodeRepository verificationCodeRepository;

  @Override
  public VerificationCode sendVerificationCode(UserModel userModel, VerificationType verificationType)
      throws Exception {
    VerificationCode verificationCode1 = new VerificationCode();
    verificationCode1.setOtp(OtpUtils.generateOtp());
    verificationCode1.setVerificationType(verificationType);
    verificationCode1.setUserId(userModel.getId());
    return verificationCodeRepository.save(verificationCode1);
  }

  @Override
  public VerificationCode getVerificationCodeById(String id) throws Exception {
    Optional<VerificationCode> verificationCode = verificationCodeRepository.findById(id);
    if (verificationCode.isPresent()) {
      return verificationCode.get();
    }
    throw new Exception("Verification Code not Found");
  }


  @Override
  public VerificationCode getvVerificationCodeByUserId(String userId) {

    return verificationCodeRepository.findByUserId(userId);
  }

  @Override
  public void deleteVerificationCodeById(VerificationCode verificationCode) {
    verificationCodeRepository.delete(verificationCode);
  }
}
