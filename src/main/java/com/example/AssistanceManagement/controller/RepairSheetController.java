package com.example.AssistanceManagement.controller;

import com.example.AssistanceManagement.exceptions.RepairSheetDateException;
import com.example.AssistanceManagement.model.Enums.Classification;
import com.example.AssistanceManagement.model.Enums.Status;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import com.example.AssistanceManagement.service.RepairSheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("repairSheet")
public class RepairSheetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductModel.class);


    @Autowired
    RepairSheetService repairSheetService;

    @GetMapping("/allSheets")
    public List<RepairSheetModel> getRepairSheets() {
        return repairSheetService.getRepairSheets();
    }

    @GetMapping("/repaired/{status}")
    public ResponseEntity<List<ProductModel>> getProductsStatus(@PathVariable Status status) {
        List<ProductModel> productModelList = repairSheetService.getProductStatus(status);
        return ResponseEntity.ok(productModelList);
    }

    @GetMapping("/prices")
    public List getPrices() {
        return repairSheetService.getCost();
    }

    @GetMapping("/getPersonnel/{classification}")
    public List getPersonnelByClassification(@PathVariable Classification classification) {
        return repairSheetService.getPersonnelByClassification(classification);
    }

    @GetMapping("/getTest/{fileId}/{productId}")
    public List search(@PathVariable Integer fileId, @PathVariable Integer productId) {
        return repairSheetService.searchByFileIdAndProductModel(fileId, productId);
    }

    @GetMapping("/{id}")
    public Optional<RepairSheetModel> getById(@PathVariable Integer id) {
        return repairSheetService.getById(id);
    }

    @PostMapping("save")
    public ResponseEntity<RepairSheetModel> save(@RequestBody RepairSheetModel repairSheetModel) {
        try {
            return ResponseEntity.ok(repairSheetService.save(repairSheetModel));
        } catch (RepairSheetDateException e) {
            LOGGER.error(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("update")
    public RepairSheetModel update(@RequestBody RepairSheetModel repairSheetModel) {
        return repairSheetService.update(repairSheetModel);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        repairSheetService.delete(id);
    }
}
