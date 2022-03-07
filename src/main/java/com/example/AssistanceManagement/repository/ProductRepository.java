package com.example.AssistanceManagement.repository;

import com.example.AssistanceManagement.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<ProductModel, Integer>, JpaSpecificationExecutor<ProductModel> {

}
