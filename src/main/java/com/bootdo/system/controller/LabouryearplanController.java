package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.LabouryearplanDO;
import com.bootdo.system.service.LabouryearplanService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-09-27 21:24:41
 */

@Controller
@RequestMapping("/system/labouryearplan")
public class LabouryearplanController {
	@Autowired
	private LabouryearplanService labouryearplanService;

	@GetMapping()
	@RequiresPermissions("system:labouryearplan:labouryearplan")
	String Labouryearplan() {
		return "system/labouryearplan/labouryearplan";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:labouryearplan:labouryearplan")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<LabouryearplanDO> labouryearplanList = labouryearplanService
				.list(query);
		int total = labouryearplanService.count(query);
		PageUtils pageUtils = new PageUtils(labouryearplanList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	// @RequiresPermissions("system:labouryearplan:add")
	String add() {
		return "system/labouryearplan/add";
	}

	@GetMapping("/edit/{oid}")
	// @RequiresPermissions("system:labouryearplan:edit")
	String edit(@PathVariable("oid") String oid, String deptname, Model model) {
		LabouryearplanDO labouryearplan = labouryearplanService.get(oid);
		model.addAttribute("labouryearplan", labouryearplan);
		model.addAttribute("deptname", deptname);
		return "system/labouryearplan/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	// @RequiresPermissions("system:labouryearplan:add")
	public R save(LabouryearplanDO labouryearplan) {
		if (labouryearplanService.addPlan(labouryearplan) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	// @RequiresPermissions("system:labouryearplan:edit")
	public R update(LabouryearplanDO labouryearplan) {
		labouryearplanService.update(labouryearplan);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("system:labouryearplan:remove")
	public R remove(String oid) {
		if (labouryearplanService.remove(oid) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	// @RequiresPermissions("system:labouryearplan:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids) {
		labouryearplanService.batchRemove(oids);
		return R.ok();
	}

}
