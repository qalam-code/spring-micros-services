package com.qalamcodde.customerservice.projection;

import com.qalamcodde.customerservice.entity.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = {Customer.class})
public interface CustomerProjection {
    public Long getId();
    public String getFirstName();
    public String getLastName();
}
