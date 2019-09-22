package com.bootdo.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootdo.common.controller.BaseController;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.ReportDeptCategoryService;
import com.bootdo.system.service.ReportDeptService;
import com.bootdo.system.service.UserService;

@Controller
@RequestMapping("/system/reportStatistics")
public class ReportStatistics extends BaseController {

	@Autowired
	private ReportDeptService reportDeptService;

	@Autowired
	private ReportDeptCategoryService reportDeptCategoryService;
	@Autowired
	UserService userService;

	@GetMapping("/staff")
	@RequiresPermissions("system:reportStatistics:staff")
	// String ShowReportStatistics(Model model){
	String ShowReportStatisticsStaff(Model model) {
		// model.addAttribute("rdcId", rdcId);
		return "system/report/staffStatistics";
	}

	@GetMapping("/capital")
	@RequiresPermissions("system:reportStatistics:capital")
	// String ShowReportStatistics(Model model){
	String ShowReportStatisticsCapital(Model model) {
		// model.addAttribute("rdcId", rdcId);
		return "system/report/capitalStatistics";
	}

	// 20001 快报和整合的使用2000x
	@GetMapping("/report/20001")
	@RequiresPermissions("system:reportStatistics:20001")
	String ShowReportStatistics20001(Model model) {
		model.addAttribute("dcode", "20001");
		return "system/report/statistics_20001";
	}

	@GetMapping("/report/20004")
	@RequiresPermissions("system:reportStatistics:20004")
	String ShowReportStatistics20004(Model model) {
		model.addAttribute("dcode", "20004");
		return "system/report/statistics_20001";
	}

	@GetMapping("/report/20002")
	@RequiresPermissions("system:reportStatistics:20002")
	String ShowReportStatistics20002(Model model) {
		model.addAttribute("dcode", "20002");
		return "system/report/statistics_20002";
	}

	@GetMapping("/report/20003")
	@RequiresPermissions("system:reportStatistics:20003")
	String ShowReportStatistics20003(Model model) {
		model.addAttribute("dcode", "20003");
		return "system/report/statistics_20002";
	}

	@GetMapping("/report/30001")
	@RequiresPermissions("system:reportStatistics:30001")
	String ShowReportStatistics30001(Model model) {
		model.addAttribute("dcode", "30001");
		return "system/report/statistics_30001";
	}

	@GetMapping("/report/30002")
	@RequiresPermissions("system:reportStatistics:30002")
	String ShowReportStatistics30002(Model model) {
		model.addAttribute("dcode", "30002");
		return "system/report/statistics_30002";
	}

	@GetMapping("/report/30003")
	@RequiresPermissions("system:reportStatistics:30003")
	String ShowReportStatistics30003(Model model) {
		model.addAttribute("dcode", "30003");
		return "system/report/statistics_30003";
	}

	@GetMapping("/report/30004")
	@RequiresPermissions("system:reportStatistics:30004")
	String ShowReportStatistics30004(Model model) {
		model.addAttribute("dcode", "30004");
		return "system/report/statistics_30004";
	}

	@GetMapping("/report/30005")
	@RequiresPermissions("system:reportStatistics:30005")
	String ShowReportStatistics30005(Model model) {
		model.addAttribute("dcode", "30005");
		return "system/report/statistics_30005";
	}

	@GetMapping("/report/30006")
	@RequiresPermissions("system:reportStatistics:30006")
	String ShowReportStatistics30006(Model model) {
		model.addAttribute("dcode", "30006");
		return "system/report/statistics_30006";
	}

	@GetMapping("/report/30007")
	@RequiresPermissions("system:reportStatistics:30007")
	String ShowReportStatistics30007(Model model) {
		model.addAttribute("dcode", "30007");
		return "system/report/statistics_30007";
	}

	@GetMapping("/report/30013")
	@RequiresPermissions("system:reportStatistics:30013")
	String ShowReportStatistics30013(Model model) {
		model.addAttribute("dcode", "30013");
		return "system/report/statistics_30013";
	}

	@GetMapping("/report/40001")
	@RequiresPermissions("system:reportStatistics:40001")
	String ShowReportStatistics40001(Model model) {
		model.addAttribute("dcode", "40001");
		return "system/report/statistics_40001";
	}

	@GetMapping("/report/20005")
	@RequiresPermissions("system:reportStatistics:20005")
	String ShowReportStatistics20005(Model model) {
		model.addAttribute("dcode", "20005");
		return "system/report/statistics_20005";
	}

	@GetMapping("/report/20008")
	@RequiresPermissions("system:reportStatistics:20008")
	String ShowReportStatistics20008(Model model) {
		model.addAttribute("dcode", "20008");
		return "system/report/statistics_20005";
	}

	@GetMapping("/report/20006")
	@RequiresPermissions("system:reportStatistics:20006")
	String ShowReportStatistics20006(Model model) {
		model.addAttribute("dcode", "20006");
		return "system/report/statistics_20007";
	}

	@GetMapping("/report/20007")
	@RequiresPermissions("system:reportStatistics:20007")
	String ShowReportStatistics20007(Model model) {
		model.addAttribute("dcode", "20007");
		return "system/report/statistics_20007";
	}

	@GetMapping("/report/50005")
	@RequiresPermissions("system:reportStatistics:50005")
	String ShowReportStatistics50005(Model model) {
		model.addAttribute("dcode", "50005");
		Long id = getUserId();
		UserDO userDO = userService.get(id);
		model.addAttribute("deptname", userDO.getDeptName());
		model.addAttribute("deptid", userDO.getDeptId().toString());
		return "system/report/statistics_50005";
	}

	@GetMapping("/report/50005sum")
	@RequiresPermissions("system:reportStatistics:50005sum")
	String ShowReportStatistics50005sum(Model model) {
		model.addAttribute("dcode", "50005");
		return "system/report/statistics_50005sum";
	}
}
