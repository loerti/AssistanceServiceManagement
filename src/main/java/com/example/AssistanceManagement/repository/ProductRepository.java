package com.example.AssistanceManagement.repository;

import com.example.AssistanceManagement.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel,Integer>, JpaSpecificationExecutor<ProductModel> {


}
