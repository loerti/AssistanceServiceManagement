package com.example.AssistanceManagement.service;

import com.example.AssistanceManagement.model.CustomerModel;
import com.example.AssistanceManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<CustomerModel> findById(Integer id){
        return customerRepository.findById(id);
    }

    public List<CustomerModel> getAll(){
        return customerRepository.findAll();
    }
    public CustomerModel saveCustomer(CustomerModel customerModel){
        return customerRepository.save(customerModel);
    }

    public CustomerModel updateProduct (CustomerModel customerModel) {
        CustomerModel existingCustomer = customerRepository.findById(customerModel.getCustomerId()).orElse(null);

        existingCustomer.setCustomerEmail(customerModel.getCustomerEmail());
        existingCustomer.setCustomerName(customerModel.getCustomerName());
        existingCustomer.setCustomerSurname(customerModel.getCustomerSurname());
        existingCustomer.setCustomerPhoneNumber(customerModel.getCustomerPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    public void deleteCostumer(int id){
        customerRepository.deleteById(id);
    }

}
