package com.bitwatch.config;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilter {

  SecurityFilterChain securityFilterChain(HttpRequest http) throws Exception {
    return null;
  }
}
