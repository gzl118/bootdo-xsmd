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

import com.bootdo.system.domain.KbGroupDO;
import com.bootdo.system.domain.ReportDeptCategoryDO;
import com.bootdo.system.service.KbGroupService;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.StringUtils;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-19 21:38:56
 */

@Controller
@RequestMapping("/system/kbGroup")
public class KbGroupController extends BaseController {
	@Autowired
	private KbGroupService kbGroupService;

	@GetMapping()
	@RequiresPermissions("system:kbGroup:kbGroup")
	String KbGroup() {
		return "system/kbGroup/kbGroup";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:kbGroup:kbGroup")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<KbGroupDO> kbGroupList = kbGroupService.list(query);
		int total = kbGroupService.count(query);
		PageUtils pageUtils = new PageUtils(kbGroupList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/grouplist")
	// @RequiresPermissions("system:reportDeptCategory:reportDeptCategory")
	public List<KbGroupDO> groupList(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<KbGroupDO> list = kbGroupService.list(query);
		return list;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:kbGroup:add")
	String add() {
		return "system/kbGroup/add";
	}

	@GetMapping("/edit/{oid}")
	@RequiresPermissions("system:kbGroup:edit")
	String edit(@PathVariable("oid") String oid, Model model) {
		KbGroupDO kbGroup = kbGroupService.get(oid);
		model.addAttribute("kbGroup", kbGroup);
		return "system/kbGroup/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:kbGroup:add")
	public R save(KbGroupDO kbGroup) {
		if (StringUtils.isEmpty(kbGroup.getOid()))
			kbGroup.setOid(UUID.randomUUID().toString().replace("-", ""));
		Long uid = getUserId();
		kbGroup.setUptuser(uid.toString());
		if (kbGroupService.save(kbGroup) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:kbGroup:edit")
	public R update(KbGroupDO kbGroup) {
		Long uid = getUserId();
		kbGroup.setUptuser(uid.toString());
		kbGroupService.update(kbGroup);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:kbGroup:remove")
	public R remove(String oid) {
		if (kbGroupService.remove(oid) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:kbGroup:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids) {
		kbGroupService.batchRemove(oids);
		return R.ok();
	}

}
