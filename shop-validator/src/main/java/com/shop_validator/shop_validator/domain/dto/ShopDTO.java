package com.shop_validator.shop_validator.domain.dto;

import java.util.List;

public record ShopDTO(
  String status,
  String identifier,
  List<ShopItemDTO> items) {}
