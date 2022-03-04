package com.example.AssistanceManagement.repository;

import com.example.AssistanceManagement.model.Enums.Classification;
import com.example.AssistanceManagement.model.Enums.Status;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface RepairSheetRepository extends JpaRepository<RepairSheetModel, Integer>, JpaSpecificationExecutor<RepairSheetModel> {

    @Query("select r.productModel from RepairSheetModel r " +
            "where r.dateCreated between ?1 and ?2 and r.repairStatus = ?3")
    List<ProductModel> getRepairSheetModelsByDateCreatedBetweenAndRepairStatus(LocalDateTime startDate, LocalDateTime endDate, Status status);

    @Query("select r.price from RepairSheetModel r " +
            "where r.dateCreated between ?1 and ?2")
    List<Double> getRepairSheetModelsPriceByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "select r.personnelModel.personnelClassification, r.personnelModel.personnelId, r.personnelModel.personnelEmail, COUNT (r.fileId) " +
            "from RepairSheetModel r " +
            "where r.dateCreated between ?1 and ?2 and r.personnelModel.personnelClassification = ?3 " +
            "GROUP BY r.personnelModel.personnelId")
    List getRepairSheetModelsByDateCreatedBetweenAndPersonnelModelIs(LocalDateTime startDate, LocalDateTime endDate, Classification classification);

}
