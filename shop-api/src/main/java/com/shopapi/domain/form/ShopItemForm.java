package com.shopapi.domain.form;

import java.math.BigDecimal;

public record ShopItemForm(
  String productIdentifier,
  Integer amount,
  BigDecimal price) {}
