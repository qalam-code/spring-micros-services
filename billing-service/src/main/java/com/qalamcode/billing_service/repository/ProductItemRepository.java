package com.qalamcode.billing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.qalamcode.billing_service.entity.ProductItem;

@RepositoryRestResource 
public interface ProductItemRepository extends JpaRepository<ProductItem,Long>{

}
