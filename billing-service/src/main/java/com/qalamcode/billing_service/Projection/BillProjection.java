package com.qalamcode.billing_service.Projection;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;


import com.qalamcode.billing_service.entity.Bill;
import com.qalamcode.billing_service.entity.ProductItem;

@Projection( types = { Bill.class },name = "BillProjection")
public interface BillProjection {

    Long getId();
    Date getBillingDate();
    Long getCustomerId();
    Collection<ProductItem> getProductItems();
}
