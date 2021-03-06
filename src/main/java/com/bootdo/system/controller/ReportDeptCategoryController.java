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

import com.bootdo.system.domain.ReportDeptCategoryDO;
import com.bootdo.system.service.ReportDeptCategoryService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 报表部门配置分类
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:10:14
 */

@Controller
@RequestMapping("/system/reportDeptCategory")
public class ReportDeptCategoryController {
	@Autowired
	private ReportDeptCategoryService reportDeptCategoryService;

	@GetMapping()
	@RequiresPermissions("system:reportDeptCategory:reportDeptCategory")
	String ReportDeptCategory(String code, Model model) {
		model.addAttribute("code", code);
		return "system/reportDeptCategory/reportDeptCategory";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:reportDeptCategory:reportDeptCategory")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ReportDeptCategoryDO> reportDeptCategoryList = reportDeptCategoryService
				.list(query);
		int total = reportDeptCategoryService.count(query);
		PageUtils pageUtils = new PageUtils(reportDeptCategoryList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/grouplist")
	// @RequiresPermissions("system:reportDeptCategory:reportDeptCategory")
	public List<ReportDeptCategoryDO> groupList(
			@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ReportDeptCategoryDO> reportDeptCategoryList = reportDeptCategoryService
				.list(query);
		return reportDeptCategoryList;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:reportDeptCategory:add")
	String add(String code, Model model) {
		model.addAttribute("code", code);
		return "system/reportDeptCategory/add";
	}

	@GetMapping("/edit/{rdcId}")
	@RequiresPermissions("system:reportDeptCategory:edit")
	String edit(@PathVariable("rdcId") Long rdcId, Model model) {
		ReportDeptCategoryDO reportDeptCategory = reportDeptCategoryService
				.get(rdcId);
		model.addAttribute("reportDeptCategory", reportDeptCategory);
		return "system/reportDeptCategory/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:reportDeptCategory:add")
	public R save(ReportDeptCategoryDO reportDeptCategory) {
		if (reportDeptCategoryService.save(reportDeptCategory) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 保存,部门配置分类
	 */
	@ResponseBody
	@PostMapping("/save/treport")
	public R saveCategory(ReportDeptCategoryDO reportDeptCategory,
			@RequestParam("ids[]") Long[] deptIds) {
		if (reportDeptCategoryService.saveCategoryAndDepts(reportDeptCategory,
				deptIds) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:reportDeptCategory:edit")
	public R update(ReportDeptCategoryDO reportDeptCategory) {
		reportDeptCategoryService.update(reportDeptCategory);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("system:reportDeptCategory:remove")
	public R remove(Long rdcId) {
		if (reportDeptCategoryService.remove(rdcId) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:reportDeptCategory:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] rdcIds) {
		reportDeptCategoryService.batchRemove(rdcIds);
		return R.ok();
	}

	@GetMapping("/kb")
	@RequiresPermissions("system:reportDeptCategory:reportDeptCategorykb")
	String ReportDeptCategorykb(String code, Model model) {
		model.addAttribute("code", code);
		return "system/reportDeptCategory/reportDeptCategorykb";
	}

	@ResponseBody
	@GetMapping("/listkb")
	@RequiresPermissions("system:reportDeptCategory:reportDeptCategorykb")
	public PageUtils listkb(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ReportDeptCategoryDO> reportDeptCategoryList = reportDeptCategoryService
				.list(query);
		int total = reportDeptCategoryService.count(query);
		PageUtils pageUtils = new PageUtils(reportDeptCategoryList, total);
		return pageUtils;
	}

	@GetMapping("/addkb")
	@RequiresPermissions("system:reportDeptCategory:addkb")
	String addkb(String code, Model model) {
		model.addAttribute("code", code);
		return "system/reportDeptCategory/addkb";
	}

	@GetMapping("/editkb/{rdcId}")
	@RequiresPermissions("system:reportDeptCategory:editkb")
	String editkb(@PathVariable("rdcId") Long rdcId, Model model) {
		ReportDeptCategoryDO reportDeptCategory = reportDeptCategoryService
				.get(rdcId);
		model.addAttribute("reportDeptCategory", reportDeptCategory);
		return "system/reportDeptCategory/editkb";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/savekb")
	@RequiresPermissions("system:reportDeptCategory:addkb")
	public R savekb(ReportDeptCategoryDO reportDeptCategory) {
		if (reportDeptCategoryService.save(reportDeptCategory) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/updatekb")
	@RequiresPermissions("system:reportDeptCategory:editkb")
	public R updatekb(ReportDeptCategoryDO reportDeptCategory) {
		reportDeptCategoryService.update(reportDeptCategory);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/removekb")
	@ResponseBody
	// @RequiresPermissions("system:reportDeptCategory:remove")
	public R removekb(Long rdcId) {
		if (reportDeptCategoryService.removekb(rdcId) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/batchRemovekb")
	@ResponseBody
	@RequiresPermissions("system:reportDeptCategory:batchRemovekb")
	public R removekb(@RequestParam("ids[]") Long[] rdcIds) {
		reportDeptCategoryService.batchRemove(rdcIds);
		return R.ok();
	}
}
