package com.qalamcodde.inventoryservice.projection;

import com.qalamcodde.inventoryservice.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = {Product.class})
public interface ProductProjection {
}
