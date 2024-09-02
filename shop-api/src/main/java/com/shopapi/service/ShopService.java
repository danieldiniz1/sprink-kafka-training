package com.shopapi.service;

import com.shopapi.domain.model.ShopModel;

import java.util.List;

public interface ShopService {

    ShopModel createShop(ShopModel shopModel);
    List<ShopModel> getAllShops();
}
