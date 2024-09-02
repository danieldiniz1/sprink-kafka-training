package com.shopapi.message;

import com.shopapi.domain.dto.ShopDTO;

public interface ShopKafkaClient {
    void sendMessage(ShopDTO shopDTO);
}
