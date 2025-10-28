package com.qalamcode.billing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.qalamcode.billing_service.entity.Bill;
import com.qalamcode.billing_service.Projection.BillProjection;

@RepositoryRestResource(excerptProjection = BillProjection.class)
public interface BillRepository extends JpaRepository<Bill, Long> {
}
