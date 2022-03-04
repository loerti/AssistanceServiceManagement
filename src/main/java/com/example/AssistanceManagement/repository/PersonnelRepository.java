package com.example.AssistanceManagement.repository;

import com.example.AssistanceManagement.model.PersonnelModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<PersonnelModel,Integer>, JpaSpecificationExecutor<PersonnelModel> {

}
