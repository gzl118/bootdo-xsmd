package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.bootdo.system.domain.ReportAutoconfigmainDO;
import com.bootdo.system.domain.ReportDeptCategoryDO;
import com.bootdo.system.service.ReportAutoconfigmainService;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.StringUtils;

/**
 * 自定义报表配置主表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:11:11
 */

@Controller
@RequestMapping("/system/reportAutoconfigmain")
public class ReportAutoconfigmainController extends BaseController {
	@Autowired
	private ReportAutoconfigmainService reportAutoconfigmainService;

	@GetMapping()
	@RequiresPermissions("system:reportAutoconfigmain:reportAutoconfigmain")
	String ReportAutoconfigmain() {
		return "system/reportAutoconfigmain/reportAutoconfigmain";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:reportAutoconfigmain:reportAutoconfigmain")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ReportAutoconfigmainDO> reportAutoconfigmainList = reportAutoconfigmainService
				.list(query);
		int total = reportAutoconfigmainService.count(query);
		PageUtils pageUtils = new PageUtils(reportAutoconfigmainList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/grouplist")
	public List<ReportAutoconfigmainDO> groupList(
			@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ReportAutoconfigmainDO> list = reportAutoconfigmainService
				.list(query);
		return list;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:reportAutoconfigmain:add")
	String add() {
		return "system/reportAutoconfigmain/add";
	}

	@GetMapping("/edit/{oid}")
	@RequiresPermissions("system:reportAutoconfigmain:edit")
	String edit(@PathVariable("oid") String oid, Model model) {
		ReportAutoconfigmainDO reportAutoconfigmain = reportAutoconfigmainService
				.get(oid);
		model.addAttribute("reportAutoconfigmain", reportAutoconfigmain);
		return "system/reportAutoconfigmain/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:reportAutoconfigmain:add")
	public R save(ReportAutoconfigmainDO reportAutoconfigmain) {
		if (StringUtils.isEmpty(reportAutoconfigmain.getOid()))
			reportAutoconfigmain.setOid(UUID.randomUUID().toString()
					.replace("-", ""));
		Long uid = getUserId();
		reportAutoconfigmain.setUptuser(uid.toString());
		if (reportAutoconfigmain.getNorder() == null)
			reportAutoconfigmain.setNorder(0);
		if (reportAutoconfigmain.getFlag() == null)
			reportAutoconfigmain.setFlag(0);
		if (reportAutoconfigmainService.save(reportAutoconfigmain) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:reportAutoconfigmain:edit")
	public R update(ReportAutoconfigmainDO reportAutoconfigmain) {
		Long uid = getUserId();
		reportAutoconfigmain.setUptuser(uid.toString());
		if (reportAutoconfigmain.getNorder() == null)
			reportAutoconfigmain.setNorder(0);
		if (reportAutoconfigmain.getFlag() == null)
			reportAutoconfigmain.setFlag(0);
		reportAutoconfigmainService.update(reportAutoconfigmain);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:reportAutoconfigmain:remove")
	public R remove(String oid) {
		if (reportAutoconfigmainService.remove(oid) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:reportAutoconfigmain:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids) {
		reportAutoconfigmainService.batchRemove(oids);
		return R.ok();
	}

}
