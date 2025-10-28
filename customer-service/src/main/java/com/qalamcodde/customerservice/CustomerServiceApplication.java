package com.qalamcodde.customerservice;

import com.qalamcodde.customerservice.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.qalamcodde.customerservice.repository.CustomerRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);

    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        return   args -> {
            repositoryRestConfiguration.exposeIdsFor(Customer.class);
            customerRepository.save(new Customer(null,"Adama","adama@sd.sn"));
            customerRepository.save(new Customer(null,"laye","laye@sd.sn"));
            customerRepository.save(new Customer(null,"amor","omar@sd.sn"));

            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
