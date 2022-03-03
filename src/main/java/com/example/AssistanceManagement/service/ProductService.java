package com.example.AssistanceManagement.service;

import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    // TODO Write CRUD operations on ProductService

    public Optional<ProductModel> findById(Integer id){
        return productRepository.findById(id);
    }
}
