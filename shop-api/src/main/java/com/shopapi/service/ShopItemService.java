package com.shopapi.service;

import com.shopapi.domain.model.ShopItemModel;

import java.util.List;

public interface ShopItemService {

    ShopItemModel create(ShopItemModel shopItemModel);

    List<ShopItemModel> createAll(List<ShopItemModel> shopItemModelList);

}
