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

import com.bootdo.system.domain.LabourrepotapproveDO;
import com.bootdo.system.service.LabourrepotapproveService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-18 15:05:33
 */
 
@Controller
@RequestMapping("/system/labourrepotapprove")
public class LabourrepotapproveController {
	@Autowired
	private LabourrepotapproveService labourrepotapproveService;
	
	@GetMapping()
	@RequiresPermissions("system:labourrepotapprove:labourrepotapprove")
	String Labourrepotapprove(String foid,Model model){
		model.addAttribute("foid", foid);
	    return "system/labourrepotapprove/labourrepotapprove";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:labourrepotapprove:labourrepotapprove")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LabourrepotapproveDO> labourrepotapproveList = labourrepotapproveService.list(query);
		int total = labourrepotapproveService.count(query);
		PageUtils pageUtils = new PageUtils(labourrepotapproveList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:labourrepotapprove:add")
	String add(){
	    return "system/labourrepotapprove/add";
	}

	@GetMapping("/edit/{oid}")
	@RequiresPermissions("system:labourrepotapprove:edit")
	String edit(@PathVariable("oid") String oid,Model model){
		LabourrepotapproveDO labourrepotapprove = labourrepotapproveService.get(oid);
		model.addAttribute("labourrepotapprove", labourrepotapprove);
	    return "system/labourrepotapprove/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:labourrepotapprove:add")
	public R save( LabourrepotapproveDO labourrepotapprove){
		if(labourrepotapproveService.save(labourrepotapprove)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:labourrepotapprove:edit")
	public R update( LabourrepotapproveDO labourrepotapprove){
		labourrepotapproveService.update(labourrepotapprove);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:labourrepotapprove:remove")
	public R remove( String oid){
		if(labourrepotapproveService.remove(oid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:labourrepotapprove:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids){
		labourrepotapproveService.batchRemove(oids);
		return R.ok();
	}
	
}
