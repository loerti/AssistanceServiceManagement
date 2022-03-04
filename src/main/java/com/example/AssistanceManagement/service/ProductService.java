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

    public Optional<ProductModel> findById(Integer id){
        return productRepository.findById(id);
    }

    public ProductModel saveProduct(ProductModel productModel){
        return productRepository.save(productModel);
    }

    public ProductModel updateProduct (ProductModel productModel) {
        ProductModel existingProduct = productRepository.findById(productModel.getProductSerialNumber()).orElse(null);

        existingProduct.setBrand(productModel.getBrand());
        existingProduct.setDateOfPurchase(productModel.getDateOfPurchase());
        existingProduct.setWarrantyExpiryDate(productModel.getWarrantyExpiryDate());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }


}
