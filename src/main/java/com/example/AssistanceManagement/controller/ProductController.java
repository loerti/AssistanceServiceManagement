package com.example.AssistanceManagement.controller;

import com.example.AssistanceManagement.exceptions.ProductDateException;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ProductController {
    @Autowired
    ProductService productService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductModel.class);


    @GetMapping("products/{id}")
    public ResponseEntity<Optional<ProductModel>> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("products")
    public List<ProductModel> getAll() {
        return productService.getAll();
    }

    @PostMapping("products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductModel productModel) {
        try {
            return ResponseEntity.ok(productService.saveProduct(productModel));
        } catch (ProductDateException e) {
            LOGGER.error(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PutMapping("products")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel productModel) {
        try {
            return ResponseEntity.ok(productService.updateProduct(productModel));
        } catch (ProductDateException e) {
            LOGGER.error(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
