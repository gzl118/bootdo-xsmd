package com.bootdo.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.system.domain.LabourreportmainDO;
import com.bootdo.system.domain.LabourrepotapproveDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.LabourreportmainService;
import com.bootdo.system.service.LabourrepotapproveService;
import com.bootdo.system.service.UserService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-11 13:33:34
 */

@Controller
@RequestMapping("/system/labourreportmain")
public class LabourreportmainController extends BaseController {
	@Autowired
	private LabourreportmainService labourreportmainService;
	@Autowired
	private LabourrepotapproveService labourrepotapproveService;
	@Autowired
	UserService userService;

	@GetMapping()
	@RequiresPermissions("system:labourreportmain:labourreportmain")
	String Labourreportmain(String Code, Model model) {
		model.addAttribute("Code", Code);
		Integer result = CheckRole();
		model.addAttribute("Status", result);
		return "system/labourreportmain/labourreportmain";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:labourreportmain:labourreportmain")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// Integer result = CheckRole();
		// params.put("status", result);
		// 查询列表数据
		Query query = new Query(params);
		List<LabourreportmainDO> labourreportmainList = labourreportmainService
				.list(query);
		int total = labourreportmainService.count(query);
		PageUtils pageUtils = new PageUtils(labourreportmainList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:labourreportmain:add")
	String add(String Code, Model model) {
		model.addAttribute("Code", Code);
		return "system/labourreportmain/add";
	}

	@GetMapping("/edit/{oid}")
	@RequiresPermissions("system:labourreportmain:edit")
	String edit(@PathVariable("oid") String oid, Model model) {
		LabourreportmainDO labourreportmain = labourreportmainService.get(oid);
		model.addAttribute("labourreportmain", labourreportmain);
		return "system/labourreportmain/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:labourreportmain:add")
	public R save(LabourreportmainDO labourreportmain) {
		Long uid = getUserId();
		if (!StringUtils.isEmpty(labourreportmain.getRenderdate()))
			labourreportmain.setRenderdate(labourreportmain.getRenderdate()
					+ "-01");
		labourreportmain.setUptuser(uid.toString());
		String pkey = labourreportmainService.getPkey(labourreportmain);
		if (!StringUtils.isEmpty(pkey)) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:labourreportmain:edit")
	public R update(LabourreportmainDO labourreportmain) {
		if (!StringUtils.isEmpty(labourreportmain.getRenderdate()))
			labourreportmain.setRenderdate(labourreportmain.getRenderdate()
					+ "-01");
		labourreportmainService.update(labourreportmain);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:labourreportmain:remove")
	public R remove(String oid, String Code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("code", Code);
		String result = labourreportmainService.delPkey(map);
		if (!StringUtils.isEmpty(result))
			return R.ok();
		// if (labourreportmainService.remove(oid) > 0) {
		// return R.ok();
		// }
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:labourreportmain:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids) {
		labourreportmainService.batchRemove(oids);
		return R.ok();
	}

	@GetMapping("/sumitinfo")
	@RequiresPermissions("system:labourreportmain:sumitinfo")
	public String sumitinfo(String oid, Model model) {
		model.addAttribute("foid", oid);
		return "system/labourreportmain/sumitinfo";
	}

	@GetMapping("/approveopt")
	@RequiresPermissions("system:labourreportmain:approve")
	public String approveopt(String oid, Model model) {
		model.addAttribute("foid", oid);
		return "system/labourreportmain/approve";
	}

	@ResponseBody
	@PostMapping("/saveapprove")
	@RequiresPermissions(value = { "system:labourreportmain:sumitinfo",
			"system:labourreportmain:approve" }, logical = Logical.OR)
	public R saveapprove(String oid, Integer status, String remark, Model model) {
		LabourreportmainDO labourreportmain = new LabourreportmainDO();
		labourreportmain.setOid(oid);
		labourreportmain.setStatus(status);
		int result = labourreportmainService.update(labourreportmain);
		if (result > 0) {
			Long uid = getUserId();
			String pkey = UUID.randomUUID().toString().replace("-", "");
			;
			LabourrepotapproveDO labourrepotapprove = new LabourrepotapproveDO();
			labourrepotapprove.setOid(pkey);
			labourrepotapprove.setFoid(oid);
			labourrepotapprove.setContent(remark);
			labourrepotapprove.setStatus(status);
			labourrepotapprove.setUptuser(uid.toString());
			result = labourrepotapproveService.save(labourrepotapprove);
			if (result > 0) {
				return R.ok();
			}
		}
		return R.error();
	}

	private Integer CheckRole() {
		Integer result = -1;
		Long id = getUserId();
		UserDO userDO = userService.get(id);
		List<Long> list = userDO.getRoleIds();
		if (list == null || list.size() == 0)
			return result;
		Long a = Long.valueOf(5);
		Long b = Long.valueOf(6);
		if (list.contains(a)) {
			return 5; // null
		}
		if (list.contains(b)) {
			return 6; // 1
		}
		return result;
	}
}
