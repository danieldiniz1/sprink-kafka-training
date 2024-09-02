package com.shopapi.domain.model;

import com.shopapi.domain.form.ShopForm;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "tb_shops")
public class ShopModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifier;

    private String status;

    @Column(name = "date_shop")
    private LocalDate dateShop;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "shop")
    private List<ShopItemModel> items = new ArrayList<>();

    public static ShopModel valueOf (List<ShopItemModel> shopItemModelList) {

        ShopModel shopModel = new ShopModel();
        shopModel.setIdentifier(UUID.randomUUID().toString());
        shopModel.setStatus("created");
        shopModel.getItems().addAll(shopItemModelList);
        shopModel.setDateShop(LocalDate.now());
        return shopModel;
    }

}
