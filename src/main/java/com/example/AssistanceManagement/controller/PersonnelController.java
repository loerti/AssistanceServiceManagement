package com.example.AssistanceManagement.controller;

import com.example.AssistanceManagement.model.PersonnelModel;
import com.example.AssistanceManagement.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class PersonnelController {

    @Autowired
    PersonnelService personnelService;

    @GetMapping("personnel/{id}")
    public ResponseEntity<Optional<PersonnelModel>> getPersonnelById(@PathVariable Integer id){
        return ResponseEntity.ok(personnelService.findById(id));
    }

    @GetMapping("personnel")
    public List<PersonnelModel> getAll(){
        return personnelService.findAll();
    }

    @PostMapping("personnel")
    public ResponseEntity<PersonnelModel> savePersonnel(@RequestBody PersonnelModel personnelModel){
        return ResponseEntity.ok(personnelService.savePersonnel(personnelModel));
    }

    @DeleteMapping("personnel/{id}")
    public void deletePersonnel(@PathVariable Integer id){
        personnelService.deletePersonnel(id);
    }

    @PutMapping("personnel")
    public ResponseEntity<PersonnelModel> updatePersonnel(@RequestBody PersonnelModel personnelModel){
        return ResponseEntity.ok(personnelService.savePersonnel(personnelModel));
    }
}
