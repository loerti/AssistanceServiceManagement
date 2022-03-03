package com.example.AssistanceManagement.repository;

import com.example.AssistanceManagement.model.Enums.Status;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;


public interface RepairSheetRepository extends JpaRepository<RepairSheetModel,Integer>, JpaSpecificationExecutor<RepairSheetModel> {


}
