package com.example.AssistanceManagement.repository;

import com.example.AssistanceManagement.model.PersonnelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonnelRepository extends JpaRepository<PersonnelModel, Integer>, JpaSpecificationExecutor<PersonnelModel> {

}
