package com.qalamcode.billing_service;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import com.qalamcode.billing_service.dto.Customer;
import com.qalamcode.billing_service.dto.Product;
import com.qalamcode.billing_service.entity.Bill;
import com.qalamcode.billing_service.entity.ProductItem;
import com.qalamcode.billing_service.repository.BillRepository;
import com.qalamcode.billing_service.repository.ProductItemRepository;
import com.qalamcode.billing_service.service.CustomerService;
import com.qalamcode.billing_service.service.InventoryService;
@SpringBootApplication(scanBasePackages = "com.qalamcode.billing_service")
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerService customerService,
							InventoryService inventoryService
							){
		return args -> {
			Customer c1 = customerService.findCustomerById(1L);			
			PagedModel <Product> products =  inventoryService.findAllProducts();
			
			Bill bill1 = billRepository.save(new Bill(null,new Date(),c1.getId(),null,null));

			products.getContent().forEach(p->{
				productItemRepository.save(new ProductItem(null,p.getId(),null,p.getPrice(),30,bill1));
			});

			System.out.println("******************************");

			System.out.println("ID = " +c1.getId());
			System.out.println("Name = " +c1.getName());
			System.out.println("Email = " +c1.getEmail());

			System.out.println("******************************");

		};
	}
 

}
	