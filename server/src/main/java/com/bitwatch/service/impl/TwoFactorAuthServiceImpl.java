package com.bitwatch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.bitwatch.models.TwoFactorOTP;
import com.bitwatch.models.UserModel;
import com.bitwatch.repository.TwoFactorOtpRepository;
import com.bitwatch.service.TwoFactorAuthService;

@Service
public class TwoFactorAuthServiceImpl implements TwoFactorAuthService {

  @Autowired
  private TwoFactorOtpRepository twoFactorOtpRepository;

  @Override
  public TwoFactorOTP createTwoFactorOtp(UserModel user, String otp, String jwt) {

    TwoFactorOTP twoFactorOTP = new TwoFactorOTP();
    twoFactorOTP.setOtp(otp);
    twoFactorOTP.setJwt(jwt);
    twoFactorOTP.setUserId(user.getId());
    return twoFactorOtpRepository.save(twoFactorOTP);
  }

  @Override
  public TwoFactorOTP findByUserId(String userId) {
    return twoFactorOtpRepository.findByUserId(userId);
  }

  @Override
  public TwoFactorOTP findById(String id) {
    Optional<TwoFactorOTP> tOptional = twoFactorOtpRepository.findById(id);
    return tOptional.orElse(null);
  }

  @Override
  public boolean verfiyTwoFactorOtp(TwoFactorOTP twoFactorOtp, String otp) {
    return twoFactorOtp.getOtp().equals(otp);
  }

  @Override
  public void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP) {
    twoFactorOtpRepository.delete(twoFactorOTP);
  }
}
