package com.shopapi.facade.impl;

import com.shopapi.domain.dto.ShopDTO;
import com.shopapi.domain.dto.ShopItemDTO;
import com.shopapi.domain.form.ShopForm;
import com.shopapi.domain.form.ShopItemForm;
import com.shopapi.domain.model.ShopItemModel;
import com.shopapi.domain.model.ShopModel;
import com.shopapi.facade.ShopFacade;
import com.shopapi.message.ShopKafkaClient;
import com.shopapi.service.ShopItemService;
import com.shopapi.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class DefaultShopFacade implements ShopFacade {

    private final ShopService shopService;

    private final ShopItemService shopItemService;
    private final ShopKafkaClient shopKafkaClient;

    @Override
    public List<ShopDTO> findAllShops () {

        return convertListShopModelToDTO(shopService.getAllShops());
    }

    @Override
    public ShopDTO saveShop (ShopForm shopForm) {
        List<ShopItemModel> items = convertShopItemFormToModel(shopForm.itemForm());
        final ShopModel shop = shopService.createShop(ShopModel.valueOf(items));
        items.forEach(i -> i.setShop(shop));
        shopItemService.createAll(items);

        final ShopDTO shopDTO = convertShopModelToDTO(shop);
        shopKafkaClient.sendMessage(shopDTO);

        return shopDTO;
    }

    private ShopDTO convertShopModelToDTO (final ShopModel model) {

        return new ShopDTO(model.getStatus(), model.getIdentifier(), getAllShopItensModelToDTO(model.getItems()));
    }

    private List<ShopItemModel> convertShopItemFormToModel (final List<ShopItemForm> shopItemForms) {
        return shopItemService.createAll(shopItemForms.stream().map(ShopItemModel::valueOf).toList());
    }

    private List<ShopDTO> convertListShopModelToDTO (final List<ShopModel> allShops) {
        return Objects.nonNull(allShops) ? allShops.stream().map(this::convertShopModelToDTO).toList() : Collections.emptyList();
    }

    private List<ShopItemDTO> getAllShopItensModelToDTO (final List<ShopItemModel> items) {

        return items.stream().map(i -> new ShopItemDTO(i.getProductIdentifier(), i.getAmount(), i.getPrice())).toList();
    }

}
