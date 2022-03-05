package com.example.AssistanceManagement.controller;

import com.example.AssistanceManagement.model.Enums.Status;
import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import com.example.AssistanceManagement.service.RepairSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("repairSheet")
public class RepairSheetController {

    @Autowired
    RepairSheetService repairSheetService;
//params end date start date and status
    @GetMapping("/allSheets")
    public List<RepairSheetModel> getRepairSheets(){
        return repairSheetService.getRepairSheets();
    }
//all sheets
    @GetMapping("/repaired/{status}")
    public ResponseEntity<List<ProductModel>> getProductsStatus(@PathVariable Status status){
        List<ProductModel> productModelList=repairSheetService.getProductStatus(status);
        return new ResponseEntity<>(productModelList, HttpStatus.OK);
    }

//    @GetMapping("/rejected")
//    public List<ProductModel> getFailedProducts(){
//        return repairSheetService.getFailedResults();
//    }

    @GetMapping("/prices")
    public List<Double> getPrices(){
        return repairSheetService.getCost();
    }

    @GetMapping("/technicians")
    public List getTechnicians(){
        return repairSheetService.getTechnicians();
    }

    @GetMapping("/getTest/{fileId}/{productId}")
    public List search(@PathVariable Integer fileId,@PathVariable Integer productId){
        return  repairSheetService.searchByFileIdAndProductModel (fileId,productId);
    }

    @GetMapping("/{id}")
    public Optional<RepairSheetModel> getById(@PathVariable Integer id){
        return repairSheetService.getById(id);
    }

    @PostMapping("save")
    public RepairSheetModel save(@RequestBody RepairSheetModel repairSheetModel){
        return repairSheetService.save(repairSheetModel);
    }

    @PutMapping("update")
    public RepairSheetModel update(@RequestBody RepairSheetModel repairSheetModel){
        return repairSheetService.update(repairSheetModel);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){
        repairSheetService.delete(id);
    }
}
