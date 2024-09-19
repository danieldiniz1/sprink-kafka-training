package com.shop_validator.shop_validator.domain.dto;

import java.math.BigDecimal;

public record ShopItemDTO(
  String productIdentifier,
  Integer amount,
  BigDecimal price) {}
