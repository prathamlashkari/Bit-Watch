package com.bitwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwatch.models.UserModel;
import com.bitwatch.repository.UserRepository;
import com.bitwatch.request.SignupReq;
import com.bitwatch.response.AuthResponse;

@RestController
@RequestMapping("/")
public class AuthController {

  @Autowired
  private UserRepository userRepository;

  public ResponseEntity<AuthResponse> signup(@RequestBody SignupReq req) throws Exception {
    return null;
  }
}
