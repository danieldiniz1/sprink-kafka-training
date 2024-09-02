package com.shopapi.repository;

import com.shopapi.domain.model.ShopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopModel,Long> {}
