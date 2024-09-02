package com.shopapi.domain.dto;

import java.math.BigDecimal;

public record ShopItemDTO(
  String productIdentifier,
  Integer amount,
  BigDecimal price) {}
