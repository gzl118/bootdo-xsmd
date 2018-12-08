package com.bootdo.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootdo.common.controller.BaseController;

@Controller
@RequestMapping("/system/reportconfig")
public class ReportConfigController extends BaseController {
	@GetMapping()
	@RequiresPermissions("system:reportconfig:reportconfig")
	String ReportConfig(String foid, Model model) {
		model.addAttribute("foid", foid);
		return "system/reportautoconfig/reportautoconfigmain";
	}

	@GetMapping("/report")
	String add(String code, String foid, Model model) {
		model.addAttribute("foid", foid);
		String tname = "system/reportautoconfig/reportconfig" + code;
		return tname;
	}
}
