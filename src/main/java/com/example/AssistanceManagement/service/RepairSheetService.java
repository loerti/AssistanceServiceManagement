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

    public List<ProductModel> getProductStatus(Status status) {
        return repairSheetRepository.getRepairSheetModelsByDateCreatedBetweenAndRepairStatus(startDate, endDate, status);
    }

    public List getCost() {
        List<RepairSheetModel> repairSheetModelList = repairSheetRepository.findAll();
        for (RepairSheetModel repairSheetModel : repairSheetModelList) {
            if (repairSheetModel.getProductModel().getWarrantyExpiryDate().isAfter(repairSheetModel.getDateCreated())) {
                repairSheetModel.setPrice((double) 0);
                repairSheetRepository.save(repairSheetModel);
            }
        }
        return repairSheetRepository.getRepairSheetModelsPriceByDateCreatedBetween(startDate, endDate);
    }

    public List getPersonnelByClassification(Classification classification) {
        return repairSheetRepository.getRepairSheetModelsByDateCreatedBetweenAndPersonnelModelIs(startDate, endDate, classification);
    }

    public List searchByFileIdAndProductModel(Integer fileID, Integer prdId) {
        return repairSheetRepository.searchByFileIdAndProductModel(fileID, prdId);
    }

    public Optional<RepairSheetModel> getById(Integer id) {
        return repairSheetRepository.findById(id);
    }

    public RepairSheetModel save(RepairSheetModel repairSheetModel) {
        return repairSheetRepository.save(repairSheetModel);
    }

    public RepairSheetModel update(RepairSheetModel repairSheetModel) {
        RepairSheetModel existingRepairSheet = repairSheetRepository.findById(repairSheetModel.getFileId()).orElse(null);

        existingRepairSheet.setPrice(repairSheetModel.getPrice());
        existingRepairSheet.setRepairStatus(repairSheetModel.getRepairStatus());
        existingRepairSheet.setDateCreated(repairSheetModel.getDateCreated());
        existingRepairSheet.setPersonnelModel(repairSheetModel.getPersonnelModel());
        existingRepairSheet.setProblemDescription(repairSheetModel.getProblemDescription());
        existingRepairSheet.setProductModel(repairSheetModel.getProductModel());
        return repairSheetRepository.save(existingRepairSheet);
    }

    public void delete(int id) {
        repairSheetRepository.deleteById(id);
    }


    // TODO Error Handling
    //  a) When creating a new product make sure the file created date is not before the product date of purchase


}
