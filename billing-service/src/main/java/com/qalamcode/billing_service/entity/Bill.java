package com.qalamcode.billing_service.entity;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qalamcode.billing_service.dto.Customer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date billingDate; // ✅ correction ici

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long customerId;

    @Transient // Non-persistant : c-a-d que l'attribut n'est pas enregistrer sur la table(base de données)
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
}
