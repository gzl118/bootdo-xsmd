package com.bootdo.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootdo.system.service.ReportDeptCategoryService;
import com.bootdo.system.service.ReportDeptService;

@Controller
@RequestMapping("/system/reportStatistics")
public class ReportStatistics {

	@Autowired
	private ReportDeptService reportDeptService;
	
	@Autowired
	private ReportDeptCategoryService reportDeptCategoryService;
	
	@GetMapping("/staff")
	@RequiresPermissions("system:reportStatistics:staff")
//	String ShowReportStatistics(Model model){
		String ShowReportStatisticsStaff(Model model){
//		model.addAttribute("rdcId", rdcId);
	    return "system/report/staffStatistics";
	}
	
	
	@GetMapping("/capital")
	@RequiresPermissions("system:reportStatistics:capital")
//	String ShowReportStatistics(Model model){
		String ShowReportStatisticsCapital(Model model){
//		model.addAttribute("rdcId", rdcId);
	    return "system/report/capitalStatistics";
	}
}
