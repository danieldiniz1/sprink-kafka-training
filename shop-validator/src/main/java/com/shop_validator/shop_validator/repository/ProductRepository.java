package com.shop_validator.shop_validator.repository;

import com.shop_validator.shop_validator.domain.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    ProductModel findByIdentifier(String identifier);
}
