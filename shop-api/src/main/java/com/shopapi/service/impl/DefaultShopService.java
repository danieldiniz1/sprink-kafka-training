package com.shopapi.service.impl;

import com.shopapi.domain.model.ShopModel;
import com.shopapi.repository.ShopRepository;
import com.shopapi.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultShopService implements ShopService {

    private final ShopRepository shopRepository;

    public DefaultShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public ShopModel createShop (final ShopModel shopModel) {

        return shopRepository.save(shopModel);
    }

    @Override
    public List<ShopModel> getAllShops () {

        return !shopRepository.findAll().isEmpty() ? shopRepository.findAll() : null;
    }

}
