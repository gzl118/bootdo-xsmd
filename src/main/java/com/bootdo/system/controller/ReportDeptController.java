package com.bootdo.system.controller;

import java.util.ArrayList;
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

import com.bootdo.system.domain.ReportDeptDO;
import com.bootdo.system.domain.UserRoleDO;
import com.bootdo.system.service.ReportDeptService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 报表部门配置对应表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:08:28
 */
 
@Controller
@RequestMapping("/system/reportDept")
public class ReportDeptController {
	@Autowired
	private ReportDeptService reportDeptService;
	
	@GetMapping()
	@RequiresPermissions("system:reportDept:reportDept")
	String ReportDept(Long rdcId,Model model){
		model.addAttribute("rdcId", rdcId);
	    return "system/reportDept/reportDept";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:reportDept:reportDept")
	public List<ReportDeptDO> list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ReportDeptDO> reportDeptList = reportDeptService.list(query);
		return reportDeptList;
	}
	@ResponseBody
	@GetMapping("/list/depts")
	public List<Long> getDepts(@RequestParam Long rdcId){
		//查询列表数据
		List<Long> reportDeptList = reportDeptService.getDeptsByRdcId(rdcId);
		return reportDeptList;
	}
	//統計报表里面的单位配置查询，不设置权限
	@ResponseBody
	@GetMapping("/list/30001")
	public List<ReportDeptDO> list30001(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ReportDeptDO> reportDeptList = reportDeptService.list(query);
		return reportDeptList;
	}
	@GetMapping("/add")
	@RequiresPermissions("system:reportDept:add")
	String add(Long parentId,Model model){
		model.addAttribute("parentId", parentId);
	    return "system/reportDept/add";
	}

	@GetMapping("/edit/{rdId}")
	@RequiresPermissions("system:reportDept:edit")
	String edit(@PathVariable("rdId") Long rdId,Model model){
		ReportDeptDO reportDept = reportDeptService.get(rdId);
		model.addAttribute("reportDept", reportDept);
	    return "system/reportDept/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:reportDept:add")
	public R save( ReportDeptDO reportDept){
		if(reportDeptService.save(reportDept)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:reportDept:edit")
	public R update( ReportDeptDO reportDept){
		reportDeptService.update(reportDept);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:reportDept:remove")
	public R remove( Long rdId){
		if(reportDeptService.remove(rdId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:reportDept:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] rdIds){
		reportDeptService.batchRemove(rdIds);
		return R.ok();
	}
	
	
	@ResponseBody()
	@PostMapping("/batchAddToDepts")
	R batchAddToDepts(@RequestParam("ids[]") Long[] deptIds,Long rdcId) {
		int r = reportDeptService.batchSave(deptIds,rdcId);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
