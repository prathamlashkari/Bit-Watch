package com.bitwatch.config;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

  private static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

}
