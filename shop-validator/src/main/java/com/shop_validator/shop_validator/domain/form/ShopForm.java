package com.shop_validator.shop_validator.domain.form;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ShopForm(
//  String status,
//  String identifier,
  @JsonProperty("items")
  List<ShopItemForm> itemForm) {}
