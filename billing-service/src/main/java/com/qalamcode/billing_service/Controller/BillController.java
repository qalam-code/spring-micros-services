
package com.qalamcode.billing_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qalamcode.billing_service.entity.Bill;
import com.qalamcode.billing_service.entity.ProductItem;
import com.qalamcode.billing_service.repository.BillRepository;
import com.qalamcode.billing_service.repository.ProductItemRepository;
import com.qalamcode.billing_service.service.CustomerService;
import com.qalamcode.billing_service.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pIt ->{
            pIt.setProduct(inventoryService.findProductById(pIt.getProductId()));
        });
        return  bill;
    }
}
