package com.bitwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwatch.models.UserModel;
import com.bitwatch.service.EmailService;
import com.bitwatch.service.UserService;

@RestController
@RequestMapping()
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private EmailService emailService;

  @GetMapping("api/users/prifile")
  public ResponseEntity<UserModel> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception {
    UserModel userModel = userService.findUserProfileByJwt(jwt);
    userModel.setPassword("Secured");
    return new ResponseEntity<>(userModel, HttpStatus.OK);
  }

  @PatchMapping("api/users/enable-two-factor/verify-otp/{otp}")
  public ResponseEntity<UserModel> enableTwoFactorAuthentication(@RequestHeader("Authorization") String jwt)
      throws Exception {
    UserModel userModel = userService.findUserProfileByJwt(jwt);
    userModel.setPassword("Secured");
    return new ResponseEntity<>(userModel, HttpStatus.OK);
  }

}
