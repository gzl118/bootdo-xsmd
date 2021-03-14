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

import com.bootdo.system.domain.KbDeptDO;
import com.bootdo.system.domain.ReportDeptDO;
import com.bootdo.system.domain.SortKbDeptDO;
import com.bootdo.system.service.KbDeptService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-19 21:38:56
 */

@Controller
@RequestMapping("/system/kbDept")
public class KbDeptController {
	@Autowired
	private KbDeptService kbDeptService;

	@GetMapping()
	@RequiresPermissions("system:kbDept:kbDept")
	String KbDept(String foid, String code, Model model) {
		model.addAttribute("foid", foid);
		model.addAttribute("code", code);
		return "system/kbDept/kbDept";
	}

	@GetMapping("/kbDeptTreeDrap")
	String deptTreeDrap(String foid, String code, Model model) {
		model.addAttribute("foid", foid);
		model.addAttribute("code", code);
		return "system/kbDept/kbDeptTreeDrap";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:kbDept:kbDept")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<KbDeptDO> kbDeptList = kbDeptService.list(query);
		int total = kbDeptService.count(query);
		PageUtils pageUtils = new PageUtils(kbDeptList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/listnew")
	@RequiresPermissions("system:kbDept:kbDept")
	public List<KbDeptDO> listnew(Integer foid) {
		// 查询列表数据
		List<KbDeptDO> kbDeptList = kbDeptService.listnew(foid);
		return kbDeptList;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:kbDept:add")
	String add(String foid, String code, Model model) {
		model.addAttribute("foid", foid);
		model.addAttribute("code", code);
		return "system/kbDept/add";
	}

	@GetMapping("/edit/{oid}")
	@RequiresPermissions("system:kbDept:edit")
	String edit(@PathVariable("oid") Integer oid, String code, Model model) {
		KbDeptDO kbDept = kbDeptService.get(oid);
		model.addAttribute("kbDept", kbDept);
		model.addAttribute("code", code);
		return "system/kbDept/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:kbDept:add")
	public R save(KbDeptDO kbDept) {
		if (kbDeptService.save(kbDept) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:kbDept:edit")
	public R update(KbDeptDO kbDept) {
		kbDeptService.update(kbDept);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:kbDept:remove")
	public R remove(Integer oid) {
		if (kbDeptService.remove(oid) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:kbDept:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] oids) {
		kbDeptService.batchRemove(oids);
		return R.ok();
	}
	@PostMapping("/changeOrder")
	@ResponseBody
	public R changeOrder(@RequestBody List<SortKbDeptDO> deptIds) {
		if (kbDeptService.updatelist(deptIds) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@GetMapping("/sortlist")
	@RequiresPermissions("system:kbDept:kbDept")
	public List<SortKbDeptDO> sortlist(Integer foid) {
		List<SortKbDeptDO> kbDeptList = kbDeptService.sortlist(foid);
		return kbDeptList;
	}
}
