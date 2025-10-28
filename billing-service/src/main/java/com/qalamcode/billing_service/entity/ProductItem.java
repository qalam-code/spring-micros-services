package com.qalamcode.billing_service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qalamcode.billing_service.dto.Product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long productId;

    @Transient // Non-persistant
    private Product product;

    private double price;
    private double quantity;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //accés selement en écriture 
    //C-a-d que quand on recuppere les information de ProductItem on aura pas accés à bill 
    // C'est un sécurité pour éviter la dépendance ciclique entre Bill et productItem
    private Bill bill;
}
