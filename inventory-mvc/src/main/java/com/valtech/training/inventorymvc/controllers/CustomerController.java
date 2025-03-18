package com.valtech.training.inventorymvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.valtech.training.inventorymvc.services.CustomerService;
import com.valtech.training.inventorymvc.vos.CustomerVO;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

  
    @PostMapping
    public CustomerVO saveCustomer(@RequestBody CustomerVO customerVO) {
        return customerService.saveCustomer(customerVO);
    }

  
    @PutMapping("/{id}")
    public CustomerVO updateCustomer(@PathVariable int id, @RequestBody CustomerVO customerVO) {
        return customerService.updateCustomer(id, customerVO);
    }


    @GetMapping("/{id}")
    public CustomerVO getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    
    @GetMapping
  
    public List<CustomerVO> getAllCustomers() {
        return customerService.getAllCustomer();
    }
}

