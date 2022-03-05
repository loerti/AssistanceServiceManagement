package com.example.AssistanceManagement.service;

import com.example.AssistanceManagement.model.Enums.Classification;
import com.example.AssistanceManagement.model.Enums.Status;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import com.example.AssistanceManagement.repository.RepairSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RepairSheetService {

    private static final LocalDateTime startDate = LocalDateTime.of(2022, 2, 1, 0, 0, 0);
    private static final LocalDateTime endDate = LocalDateTime.of(2022, 4, 1, 0, 0, 0);

//    private static final Logger LOGGER = LoggerFactory.getLogger(RepairSheetService.class);

    @Autowired
    RepairSheetRepository repairSheetRepository;

    @Autowired
    ProductService productService;

    public List<RepairSheetModel> getRepairSheets() {
        return repairSheetRepository.findAll();
    }

    public List<ProductModel> getRepairedResults(){
        return repairSheetRepository.getRepairSheetModelsByDateCreatedBetweenAndRepairStatus(startDate,endDate,Status.Completed);
    }

    public List<ProductModel> getFailedResults(){
        return repairSheetRepository.getRepairSheetModelsByDateCreatedBetweenAndRepairStatus(startDate,endDate,Status.Rejected);
    }

    public List<Double> getCost(){
        updatePrice(repairSheetRepository);
        return repairSheetRepository.getRepairSheetModelsPriceByDateCreatedBetween(startDate,endDate);
    }

    public List getTechnicians(){
        return repairSheetRepository.getRepairSheetModelsByDateCreatedBetweenAndPersonnelModelIs(startDate,endDate,Classification.Technician);
    }

    public List searchBySomething(Integer fileID ,Integer prdId){
        return repairSheetRepository.searchByFileIdAndAndProductModel(fileID,prdId);
    }

    public Optional<RepairSheetModel> getById(Integer id){
        return repairSheetRepository.findById(id);
    }

    public RepairSheetModel save(RepairSheetModel repairSheetModel){
        return repairSheetRepository.save(repairSheetModel);
    }

    public RepairSheetModel update (RepairSheetModel repairSheetModel) {
        RepairSheetModel existingRepairSheet = repairSheetRepository.findById(repairSheetModel.getFileId()).orElse(null);

        existingRepairSheet.setPrice(repairSheetModel.getPrice());
        existingRepairSheet.setRepairStatus(repairSheetModel.getRepairStatus());
        existingRepairSheet.setDateCreated(repairSheetModel.getDateCreated());
        existingRepairSheet.setPersonnelModel(repairSheetModel.getPersonnelModel());
        existingRepairSheet.setProblemDescription(repairSheetModel.getProblemDescription());
        existingRepairSheet.setProductModel(repairSheetModel.getProductModel());
        return repairSheetRepository.save(existingRepairSheet);
    }

    public void delete(int id){
        repairSheetRepository.deleteById(id);
    }



    // TODO fix the update price bug. It doesn't set to 0 the prices that are within warranty
    // TODO 1) Error Handling 2) show the website 3) get data in between as path parameters
    void updatePrice(RepairSheetRepository repairSheetRepository) {
        List<RepairSheetModel> repairSheetModelList = repairSheetRepository.findAll();

        for (RepairSheetModel repairSheetModel : repairSheetModelList) {
            if (repairSheetModel.getProductModel().getWarrantyExpiryDate().isAfter(repairSheetModel.getDateCreated())) {
                repairSheetModel.setPrice((double) 0);
            }
        }
    }

}
