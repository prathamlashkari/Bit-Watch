package com.bitwatch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;
import com.bitwatch.config.JwtProvider;
import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.TwoFactorAuth;
import com.bitwatch.models.UserModel;
import com.bitwatch.repository.UserRepository;
import com.bitwatch.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserModel findUserProfileByJwt(String jwt) throws Exception {

    String email = JwtProvider.getEmailFromToken(jwt);
    UserModel userModel = userRepository.findByEmail(email);
    if (userModel == null) {
      throw new Exception("User not found with this email");
    }
    return userModel;
  }

  @Override
  public UserModel findUserByEmail(String email) throws Exception {

    UserModel userModel = userRepository.findByEmail(email);
    if (userModel == null) {
      throw new Exception("User not found with this email");
    }
    return userModel;
  }

  @Override
  public UserModel findUserById(String id) throws Exception {

    Optional<UserModel> useropt = userRepository.findById(id);
    if (useropt.isEmpty()) {
      throw new Exception("User not found with this email");
    }
    return useropt.get();

  }

  @Override
  public UserModel enalbeTwoFactorAuthentication(VerificationType verificationType, UserModel user) {
    TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
    twoFactorAuth.setEnalbled(true);
    twoFactorAuth.setSendTo(verificationType);
    user.setTwoFactorAuth(twoFactorAuth);
    return userRepository.save(user);
  }

  @Override
  public UserModel updatePassword(UserModel user, String newPassword) {

    user.setPassword(passwordEncoder.encode(newPassword));
    return userRepository.save(user);
  }

}
