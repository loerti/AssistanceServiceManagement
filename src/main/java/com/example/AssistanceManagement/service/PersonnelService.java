package com.example.AssistanceManagement.service;

import com.example.AssistanceManagement.model.PersonnelModel;
import com.example.AssistanceManagement.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonnelService {
    @Autowired
    PersonnelRepository personnelRepository;

    public Optional<PersonnelModel> findById(Integer id){
        return personnelRepository.findById(id);
    }

    public PersonnelModel savePersonnel(PersonnelModel personnelModel){
        return personnelRepository.save(personnelModel);
    }

    public PersonnelModel updatePersonnel (PersonnelModel personnelModel) {
        PersonnelModel existingPersonnel = personnelRepository.findById(personnelModel.getPersonnelId()).orElse(null);

        existingPersonnel.setPersonnelEmail(personnelModel.getPersonnelEmail());
        existingPersonnel.setPersonnelPassword(personnelModel.getPersonnelPassword());
        existingPersonnel.setPersonnelClassification(personnelModel.getPersonnelClassification());
        existingPersonnel.setCustomerModel(personnelModel.getCustomerModel());
        return personnelRepository.save(existingPersonnel);
    }

    public void deletePersonnel(int id){
        personnelRepository.deleteById(id);
    }
}
