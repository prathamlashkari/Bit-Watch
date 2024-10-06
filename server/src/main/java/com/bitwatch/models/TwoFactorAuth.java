package com.bitwatch.models;

import com.bitwatch.enums.VerificationType;

import lombok.Data;

@Data
public class TwoFactorAuth {
  private boolean isEnalbled = false;
  private VerificationType sendTo;
}
