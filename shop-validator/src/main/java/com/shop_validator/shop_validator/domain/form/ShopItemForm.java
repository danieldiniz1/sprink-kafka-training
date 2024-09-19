package com.shop_validator.shop_validator.domain.form;

import java.math.BigDecimal;

public record ShopItemForm(
  String productIdentifier,
  Integer amount,
  BigDecimal price) {}
