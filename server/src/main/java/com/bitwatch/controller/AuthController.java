package com.bitwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwatch.config.JwtProvider;
import com.bitwatch.models.UserModel;
import com.bitwatch.repository.UserRepository;
import com.bitwatch.request.SignupReq;
import com.bitwatch.response.AuthResponse;

@RestController
@RequestMapping("/")
public class AuthController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public ResponseEntity<AuthResponse> signup(@RequestBody SignupReq req) throws Exception {
    UserModel user = userRepository.findByEmail(req.getEmail());
    if (user != null) {
      throw new Exception("User with this email already exist");
    }

    UserModel creatUserModel = new UserModel();
    creatUserModel.setFullName(req.getFullName());
    creatUserModel.setEmail(req.getEmail());
    creatUserModel.setPassword(passwordEncoder.encode(req.getPassword()));
    UserModel savedUser = userRepository.save(creatUserModel);
    Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
        savedUser.getPassword());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = JwtProvider.generateToken(authentication);
    AuthResponse authResponse = new AuthResponse();
    authResponse.setJwt(jwt);
    authResponse.setStatus(true);
    authResponse.setMsg("Register Success");

    return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
  }
}
