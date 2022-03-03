package com.example.AssistanceManagement.service;

import com.example.AssistanceManagement.model.Enums.Status;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import com.example.AssistanceManagement.repository.RepairSheetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RepairSheetService {

    private static final LocalDateTime startDate = LocalDateTime.of(2022, 2, 1, 0, 0, 0);
    private static final LocalDateTime endDate = LocalDateTime.of(2022, 4, 1, 0, 0, 0);

    private static final Logger LOGGER = LoggerFactory.getLogger(RepairSheetService.class);

    @Autowired
    RepairSheetRepository repairSheetRepository;

    @Autowired
    ProductService productService;


    public List<RepairSheetModel> getRepairSheets() {
        LOGGER.error("The repair Sheet Runs");
        return repairSheetRepository.findAll();
    }

    public List<ProductModel> getRepairedProducts() {

        List<ProductModel> repairedProductModelList = new ArrayList<>();

        for (RepairSheetModel repairSheetModel : getRepairSheets()) {
            if (repairSheetModel.getDateCreated().isAfter(startDate) && repairSheetModel.getDateCreated().isBefore(endDate)) {
                if (repairSheetModel.getRepairStatus().equals(Status.Completed)) {
                    repairedProductModelList.add(repairSheetModel.getProductModel());
                }
            }
        }
        return repairedProductModelList;
    }

//    public List<RepairSheetModel> getRepairedProducts(){
//        return repairSheetRepository.findRepairSheetModelByDateCreatedBetweenAndRepairStatus(startDate,endDate,Status.Completed);
//    }

    public List<ProductModel> getRejectedProducts() {

        List<ProductModel> rejectedProductModelList = new ArrayList<>();

        for (RepairSheetModel repairSheetModel : getRepairSheets()) {
            if (repairSheetModel.getDateCreated().isAfter(startDate) &&
                    repairSheetModel.getDateCreated().isBefore(endDate)) {
                if (repairSheetModel.getRepairStatus().equals(Status.Rejected)) {
                    rejectedProductModelList.add(repairSheetModel.getProductModel());
                }
            }
        }
        return rejectedProductModelList;
    }

    public Map<Integer, Double> getProductsPrice() {

        Map<Integer, Double> prices = new HashMap<>();
        // If the product warranty is not expired set the price to 0
        for (RepairSheetModel repairSheetModel : getRepairSheets()) {
            if (repairSheetModel.getDateCreated().isAfter(startDate) &&
                    repairSheetModel.getDateCreated().isBefore(endDate)) {
                prices.put(repairSheetModel.getProductModel().getProductSerialNumber(), repairSheetModel.getPrice());
            }
        }
        return prices;

    }

//    void updatePrice(RepairSheetRepository repairSheetRepository) {
//        List<RepairSheetModel> repairSheetModelList = repairSheetRepository.findAll();
//
//        for (RepairSheetModel repairSheetModel : repairSheetModelList) {
//            if (repairSheetModel.getProductModel().getWarrantyExpiryDate().isAfter(repairSheetModel.getDateCreated())) {
//                repairSheetModel.setPrice(0.0);
//            }
//        }
//    }


}
