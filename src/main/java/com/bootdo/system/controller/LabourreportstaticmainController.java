package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.Logical;
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

import com.bootdo.system.domain.LabourreportmainDO;
import com.bootdo.system.domain.LabourreportstaticmainDO;
import com.bootdo.system.domain.LabourrepotapproveDO;
import com.bootdo.system.service.LabourreportstaticmainService;
import com.bootdo.system.service.LabourrepotapproveService;
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
 * @date 2018-12-06 09:30:46
 */

@Controller
@RequestMapping("/system/labourreportstaticmain")
public class LabourreportstaticmainController extends BaseController {
	@Autowired
	private LabourreportstaticmainService labourreportstaticmainService;
	@Autowired
	private LabourrepotapproveService labourrepotapproveService;

	@GetMapping()
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmain")
	String Labourreportstaticmain(Model model) {
		model.addAttribute("Code", "30001");
		model.addAttribute("Status", "");
		return "system/labourreportstaticmain/labourreportstaticmain";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmain")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<LabourreportstaticmainDO> labourreportstaticmainList = labourreportstaticmainService
				.list(query);
		int total = labourreportstaticmainService.count(query);
		PageUtils pageUtils = new PageUtils(labourreportstaticmainList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:labourreportstaticmain:add")
	String add(String rdate, String rdepart, String code, Integer ctype,
			Model model) {
		model.addAttribute("rdate", rdate);
		model.addAttribute("rdepart", rdepart);
		model.addAttribute("code", code);
		model.addAttribute("ctype", ctype);
		return "system/labourreportstaticmain/add";
	}

	@GetMapping("/edit/{oid}")
	@RequiresPermissions("system:labourreportstaticmain:edit")
	String edit(@PathVariable("oid") String oid, Model model) {
		LabourreportstaticmainDO labourreportstaticmain = labourreportstaticmainService
				.get(oid);
		model.addAttribute("labourreportstaticmain", labourreportstaticmain);
		return "system/labourreportstaticmain/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:labourreportstaticmain:add")
	public R save(LabourreportstaticmainDO labourreportstaticmain) {
		if (StringUtils.isEmpty(labourreportstaticmain.getOid()))
			labourreportstaticmain.setOid(UUID.randomUUID().toString()
					.replace("-", ""));
		if (!StringUtils.isEmpty(labourreportstaticmain.getRenderdate()))
			labourreportstaticmain.setRenderdate(labourreportstaticmain
					.getRenderdate() + "-01");
		Long uid = getUserId();
		labourreportstaticmain.setUptuser(uid.toString());
		if (labourreportstaticmainService.save(labourreportstaticmain) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:labourreportstaticmain:edit")
	public R update(LabourreportstaticmainDO labourreportstaticmain) {
		if (!StringUtils.isEmpty(labourreportstaticmain.getRenderdate()))
			labourreportstaticmain.setRenderdate(labourreportstaticmain
					.getRenderdate() + "-01");
		labourreportstaticmainService.update(labourreportstaticmain);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:labourreportstaticmain:remove")
	public R remove(String oid) {
		if (labourreportstaticmainService.remove(oid) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:labourreportstaticmain:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids) {
		labourreportstaticmainService.batchRemove(oids);
		return R.ok();
	}

	@GetMapping("/sumitinfo")
	@RequiresPermissions("system:labourreportstaticmain:sumitinfo")
	public String sumitinfo(String oid, Model model) {
		model.addAttribute("foid", oid);
		return "system/labourreportstaticmain/sumitinfo";
	}

	@ResponseBody
	@PostMapping("/saveapprove")
	@RequiresPermissions(value = { "system:labourreportmain:approve",
			"system:labourreportstaticmain:sumitinfo" }, logical = Logical.OR)
	public R saveapprove(String oid, Integer status, String remark, Model model) {
		LabourreportstaticmainDO labourreportmain = new LabourreportstaticmainDO();
		labourreportmain.setOid(oid);
		labourreportmain.setStatus(status);
		int result = labourreportstaticmainService.update(labourreportmain);
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
}
