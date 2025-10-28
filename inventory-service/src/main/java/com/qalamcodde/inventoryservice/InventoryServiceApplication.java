package com.qalamcodde.inventoryservice;

import com.qalamcodde.inventoryservice.entity.Product;
import com.qalamcodde.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        return   args -> {
            repositoryRestConfiguration.exposeIdsFor(Product.class);
            
            productRepository.save(new Product(null,"Mangue",500));
            productRepository.save(new Product(null,"Orange",250));
            productRepository.save(new Product(null,"goyabe",50));

            productRepository.findAll().forEach(System.out::println);
        };
    }
}
