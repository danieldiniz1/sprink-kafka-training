package com.shopapi.service.impl;

import com.shopapi.domain.model.ShopItemModel;
import com.shopapi.repository.ShopItemRepository;
import com.shopapi.service.ShopItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultShopItemService implements ShopItemService {

    private final ShopItemRepository shopItemRepository;

    public DefaultShopItemService(ShopItemRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;
    }

    @Override
    public ShopItemModel create (final ShopItemModel shopItemModel) {

        return shopItemRepository.save(shopItemModel);
    }

    @Override
    public List<ShopItemModel> createAll (final List<ShopItemModel> shopItemModelList) {

        return shopItemRepository.saveAll(shopItemModelList);
    }

}
