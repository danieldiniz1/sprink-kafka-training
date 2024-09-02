package com.shopapi.controller;

import com.shopapi.domain.dto.ShopDTO;
import com.shopapi.domain.form.ShopForm;
import com.shopapi.facade.ShopFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")
public class ShopController {

    private ShopFacade shopFacade;

    public ShopController (ShopFacade shopFacade) {

        this.shopFacade = shopFacade;
    }

    @GetMapping
    public ResponseEntity<List<ShopDTO>> getAllShpt () {

        return ResponseEntity.status(HttpStatus.OK).body(shopFacade.findAllShops());
    }

    @PostMapping
    public ResponseEntity<ShopDTO> saveShop (@RequestBody ShopForm shopForm) {

        System.out.printf(String.format("form: %s", shopForm));
        return ResponseEntity.status(HttpStatus.CREATED).body(shopFacade.saveShop(shopForm));
    }
}