package com.bootdo.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//20001  快报和整合的使用2000x
	@GetMapping("/report/20001")
	@RequiresPermissions("system:reportStatistics:20001")
		String ShowReportStatistics20001(Model model){
		model.addAttribute("code", "20001");
	    return "system/report/statistics_20001";
	}
	//20001  快报和整合的使用2000x
	@GetMapping("/report/20002")
	@RequiresPermissions("system:reportStatistics:20002")
		String ShowReportStatistics20002(Model model){
		model.addAttribute("code", "20002");
	    return "system/report/statistics_20002";
	}
	
	@GetMapping("/report/30001")
	@RequiresPermissions("system:reportStatistics:30001")
		String ShowReportStatistics_new(Model model){
		model.addAttribute("dcode", "30001");
	    return "system/report/statistics_30001";
	}
}
