package com.shopapi.domain.model;

import com.shopapi.domain.form.ShopItemForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_shop_items")
public class ShopItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "p_product_identifier")
    private String productIdentifier;

    private Integer amount;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopModel shop;

    public static ShopItemModel valueOf (ShopItemForm itemForm) {

        ShopItemModel model = new ShopItemModel();
        model.setProductIdentifier(itemForm.productIdentifier());
        model.setAmount(itemForm.amount());
        model.setPrice(itemForm.price());
        return model;
    }

}
