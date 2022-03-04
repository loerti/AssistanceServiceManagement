package com.example.AssistanceManagement.repository;

import com.example.AssistanceManagement.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>, JpaSpecificationExecutor<CustomerModel> {

}
