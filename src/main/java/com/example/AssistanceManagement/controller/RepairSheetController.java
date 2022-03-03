package com.example.AssistanceManagement.controller;

import com.example.AssistanceManagement.model.ProductModel;
import com.example.AssistanceManagement.model.RepairSheetModel;
import com.example.AssistanceManagement.service.ProductService;
import com.example.AssistanceManagement.service.RepairSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("repairSheet")
public class RepairSheetController {

    @Autowired
    ProductService productService;
    @Autowired
    RepairSheetService repairSheetService;

    @GetMapping("/allSheets")
    public List<RepairSheetModel> getRepairSheets(){
        return repairSheetService.getRepairSheets();
    }

    @GetMapping("/repaired")
    public List<ProductModel> getRepairedProducts(){
        return repairSheetService.getRepairedProducts();
    }

    @GetMapping("/rejected")
    public List<ProductModel> getFailedProducts(){
        return repairSheetService.getRejectedProducts();
    }

    @GetMapping("/prices")
    public Map<Integer, Double> getPrices(){
        return repairSheetService.getProductsPrice();
    }

}
