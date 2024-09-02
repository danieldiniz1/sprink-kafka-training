package com.shopapi.domain.dto;

import java.util.List;

public record ShopDTO(
  String status,
  String identifier,
  List<ShopItemDTO> items) {}
