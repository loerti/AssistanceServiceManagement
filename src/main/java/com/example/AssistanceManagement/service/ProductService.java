package com.example.AssistanceManagement.service;

import com.example.AssistanceManagement.exceptions.ProductDateException;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Optional<ProductModel> findById(Integer id) {
        return productRepository.findById(id);
    }

    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    public ProductModel saveProduct(ProductModel productModel) throws ProductDateException {
        if (productModel.getWarrantyExpiryDate().isAfter(productModel.getDateOfPurchase())) {
            return productRepository.save(productModel);
        } else throw new ProductDateException();
    }

    public ProductModel updateProduct(ProductModel productModel) {
        ProductModel existingProduct = productRepository.findById(productModel.getProductSerialNumber()).orElse(null);

        existingProduct.setBrand(productModel.getBrand());
        existingProduct.setDateOfPurchase(productModel.getDateOfPurchase());
        existingProduct.setWarrantyExpiryDate(productModel.getWarrantyExpiryDate());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }


}
