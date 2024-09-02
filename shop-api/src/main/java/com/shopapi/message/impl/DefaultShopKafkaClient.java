package com.shopapi.message.impl;

import com.shopapi.domain.dto.ShopDTO;
import com.shopapi.message.ShopKafkaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultShopKafkaClient implements ShopKafkaClient {

    private final KafkaTemplate<String, ShopDTO> kafkaTemplate;

    private static final String SHOP_TOPIC_NAME = "SHOP_TOPIC";

    @Override
    public void sendMessage (final ShopDTO msg) {
        kafkaTemplate.send(SHOP_TOPIC_NAME, msg);
    }

}
