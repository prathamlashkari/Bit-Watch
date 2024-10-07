package com.bitwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwatch.config.JwtProvider;
import com.bitwatch.models.UserModel;
import com.bitwatch.repository.UserRepository;
import com.bitwatch.request.LoginReq;
import com.bitwatch.request.SignupReq;
import com.bitwatch.response.AuthResponse;
import com.bitwatch.service.CustomUserDetailSerivce;

@RestController
@RequestMapping("/")
public class AuthController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private CustomUserDetailSerivce customUserDetailSerivce;

  @PostMapping("/signup")
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

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody LoginReq req) throws Exception {

    Authentication authentication = authenticate(req.getEmail(), req.getPassWord());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = JwtProvider.generateToken(authentication);
    AuthResponse authResponse = new AuthResponse();
    authResponse.setJwt(jwt);
    authResponse.setStatus(true);
    authResponse.setMsg("Register Success");

    return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
  }

  private Authentication authenticate(String email, String password) throws Exception {
    UserDetails userDetails = customUserDetailSerivce.loadUserByUsername(email);
    if (userDetails == null) {
      throw new Exception("Invalid email");
    }
    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
      throw new Exception("Invalid Password");
    }
    return new UsernamePasswordAuthenticationToken(email, password, userDetails.getAuthorities());
  }
}
