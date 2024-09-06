/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Reportrepairhistory;
import com.husony.service.CategoryService;
import com.husony.service.ReportRepairHistoryService;
import com.husony.service.ReportService;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class ReportRepairHistoryController {
    @Autowired
    private ReportRepairHistoryService reportRepairService;
    
    @Autowired
    private CategoryService cateService;
    
    @Autowired
    private ReportService reportService;
    
    @RequestMapping("/reportrepairhistory")
    public String reportIndex(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("reports", this.reportRepairService.getReportRepairHistorys(params));
        return "reportRepairHistory";
    }

    @GetMapping("/reportrepairhistory/add")
    public String createView(Model model) {
        model.addAttribute("reportRepair", new Reportrepairhistory());
        model.addAttribute("cates", this.cateService.getCates());
        model.addAttribute("reports", this.reportService.getReports(null));
        return "addReportRepairHistory";
    }

    @PostMapping("/reportrepairhistory/addOrUpdate")
    public String createView(Model model,
            @ModelAttribute(value = "reportRepair") @Valid Reportrepairhistory r,
            BindingResult rs) {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return "addReportRepairHistory";
        }

        try {
            Date date = new Date();
            r.setCreatedDate(date);
            this.reportRepairService.addOrUpdate(r);
            return "redirect:/reportrepairhistory";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "addReportRepairHistory";
    }

    @GetMapping("/reportrepairhistory/{reportId}")
    public String updateView(Model model, @PathVariable(value = "reportId") long id) {
        model.addAttribute("reportRepair", this.reportRepairService.getReportRepairHistoryById(id));
        model.addAttribute("cates", this.cateService.getCates());
        model.addAttribute("reports", this.reportService.getReports(null));
        return "addReportRepairHistory";
    }
}
