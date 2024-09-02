package com.shopapi.facade;

import com.shopapi.domain.dto.ShopDTO;
import com.shopapi.domain.form.ShopForm;

import java.util.List;

public interface ShopFacade {

    List<ShopDTO> findAllShops ();

    ShopDTO saveShop (ShopForm shopForm);

}
