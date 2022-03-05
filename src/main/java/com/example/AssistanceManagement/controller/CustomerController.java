package com.example.AssistanceManagement.controller;

import com.example.AssistanceManagement.model.CustomerModel;
import com.example.AssistanceManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("customer/{id}")
    public ResponseEntity<Optional<CustomerModel>> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("customer")
    public List<CustomerModel> getAll(){
        return customerService.getAll();
    }

    @PostMapping("customer")
    public ResponseEntity<CustomerModel> saveCustomer(@RequestBody CustomerModel customerModel){
        return ResponseEntity.ok(customerService.saveCustomer(customerModel));
    }

    @DeleteMapping("customer/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteCostumer(id);
    }

    @PutMapping("customer")
    public ResponseEntity<CustomerModel> updateCustomer(@RequestBody CustomerModel customerModel){
        return ResponseEntity.ok(customerService.updateProduct(customerModel));
    }
}
