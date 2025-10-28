package com.qalamcode.billing_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private double price;

}
