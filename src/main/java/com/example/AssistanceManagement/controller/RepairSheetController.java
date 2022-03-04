package com.example.AssistanceManagement.controller;

import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import com.example.AssistanceManagement.service.RepairSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("repairSheet")
public class RepairSheetController {

    @Autowired
    RepairSheetService repairSheetService;

    @GetMapping("/allSheets")
    public List<RepairSheetModel> getRepairSheets(){
        return repairSheetService.getRepairSheets();
    }

    @GetMapping("/repaired")
    public List<ProductModel> getRepairedProducts(){
        return repairSheetService.getRepairedResults();
    }

    @GetMapping("/rejected")
    public List<ProductModel> getFailedProducts(){
        return repairSheetService.getFailedResults();
    }

    @GetMapping("/prices")
    public List<Double> getPrices(){
        return repairSheetService.getCost();
    }

    @GetMapping("/technicians")
    public List getTechnicians(){
        return repairSheetService.getTechnicians();
    }

}
