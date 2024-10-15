package com.bitwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwatch.enums.VerificationType;
import com.bitwatch.models.ForgotPassword;
import com.bitwatch.models.UserModel;
import com.bitwatch.models.VerificationCode;
import com.bitwatch.request.ForgotPasswordReq;
import com.bitwatch.response.AuthResponse;
import com.bitwatch.service.EmailService;
import com.bitwatch.service.ForgotPasswordService;
import com.bitwatch.service.UserService;
import com.bitwatch.service.VerificationCodeSerice;
import com.bitwatch.utils.OtpUtils;

@RestController
@RequestMapping()
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private EmailService emailService;

  @Autowired
  private ForgotPasswordService forgotPasswordService;

  @Autowired
  private VerificationCodeSerice verificationCodeSerice;

  @GetMapping("api/users/prifile")
  public ResponseEntity<UserModel> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception {
    UserModel userModel = userService.findUserProfileByJwt(jwt);
    userModel.setPassword("Secured");
    return new ResponseEntity<>(userModel, HttpStatus.OK);
  }

  @PatchMapping("api/users/enable-two-factor/verify-otp/{otp}")
  public ResponseEntity<UserModel> enableTwoFactorAuthentication(@RequestHeader("Authorization") String jwt,
      @PathVariable String otp)
      throws Exception {
    UserModel userModel = userService.findUserProfileByJwt(jwt);
    VerificationCode verificationCode = verificationCodeSerice.getvVerificationCodeByUserId(userModel.getId());
    @SuppressWarnings("unused")
    String sendTo = verificationCode.getVerificationType().equals(VerificationType.EMAIL) ? verificationCode.getEmail()
        : verificationCode.getMobile();
    boolean isVerified = verificationCode.getOtp().equals(otp);
    if (isVerified) {
      UserModel updateUser = userService.enalbeTwoFactorAuthentication(verificationCode.getVerificationType(),
          userModel);
      return new ResponseEntity<>(updateUser, HttpStatus.OK);

    }
    throw new Exception("Wrong Otp");
  }

  @PostMapping("api/users/verification/{verificationType}/send-otp")
  public ResponseEntity<String> sendVerificationOtp(@RequestHeader("Authorization") String jwt,
      @PathVariable VerificationType verificationType)
      throws Exception {
    UserModel userModel = userService.findUserProfileByJwt(jwt);
    VerificationCode verificationCode = verificationCodeSerice.getvVerificationCodeByUserId(userModel.getId());
    if (verificationCode == null) {
      verificationCode = verificationCodeSerice.sendVerificationCode(userModel, verificationType);
    }

    if (verificationType.equals(VerificationType.EMAIL)) {
      emailService.sendVerificationOtpEmail(userModel.getEmail(), verificationCode.getOtp());
    }

    return new ResponseEntity<>("Verification Otp send Successfully", HttpStatus.OK);
  }

  @PostMapping("auth/users/reset-password/send-otp")
  public ResponseEntity<AuthResponse> sendForgotPasswordOtp(
      @RequestBody ForgotPasswordReq req)
      throws Exception {
    UserModel userModel = userService.findUserByEmail(req.getSendTo());
    String otp = OtpUtils.generateOtp();

    ForgotPassword token = forgotPasswordService.findByUser(userModel.getId());
    if (token == null) {
      token = forgotPasswordService.createToken(userModel, otp, req.getVerificationType(), req.getSendTo());
    }
    if (req.getVerificationType().equals(VerificationType.EMAIL)) {
      emailService.sendVerificationOtpEmail(userModel.getEmail(), token.getOtp());
    }
    AuthResponse res = new AuthResponse();
    res.setSession(token.getId());
    res.setMsg("Password reset otp sent Successfully");
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @PostMapping("api/users/verification/{verificationType}/send-otp")
  public ResponseEntity<String> sendVerificationOtp(@RequestHeader("Authorization") String jwt,
      @PathVariable VerificationType verificationType)
      throws Exception {
    UserModel userModel = userService.findUserProfileByJwt(jwt);
    VerificationCode verificationCode = verificationCodeSerice.getvVerificationCodeByUserId(userModel.getId());
    if (verificationCode == null) {
      verificationCode = verificationCodeSerice.sendVerificationCode(userModel, verificationType);
    }

    if (verificationType.equals(VerificationType.EMAIL)) {
      emailService.sendVerificationOtpEmail(userModel.getEmail(), verificationCode.getOtp());
    }

    return new ResponseEntity<>("Verification Otp send Successfully", HttpStatus.OK);
  }

}
