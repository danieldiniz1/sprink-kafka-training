package com.shopapi.repository;

import com.shopapi.domain.model.ShopItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItemModel,Long> {}
