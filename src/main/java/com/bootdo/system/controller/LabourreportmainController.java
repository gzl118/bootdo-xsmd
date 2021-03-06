package com.bootdo.system.controller;

import java.util.ArrayList;
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
import com.bootdo.system.domain.DeptDO;
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
		Long id = getUserId();
		model.addAttribute("Status", result);
		model.addAttribute("uid", id);
		return "system/labourreportmain/labourreportmain";
	}
	
	@GetMapping("/Labouryearreportmain")
	@RequiresPermissions("system:labourreportmain:labourreportmain")
	String Labouryearreportmain(String Code, Model model) {
		model.addAttribute("Code", Code);
		Integer result = CheckRole();
		Long id = getUserId();
		model.addAttribute("Status", result);
		model.addAttribute("uid", id);
		return "system/labourreportmain/Labouryearreportmain";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:labourreportmain:labourreportmain")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		UserDO u = getUser();
		if (params.get("status").equals("5"))
			params.put("ext1", u.getDeptId().toString());
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
		Long id = getUserId();
		UserDO userDO = userService.get(id);
		model.addAttribute("renderdepart", userDO.getDeptName());
		model.addAttribute("ext1", userDO.getDeptId().toString());
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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", labourreportmain.getCode());
		params.put("ext1", labourreportmain.getExt1());
		params.put("renderdate", labourreportmain.getRenderdate());
		List<LabourreportmainDO> labourreportmainList = labourreportmainService
				.getByCondition(params);
		if (labourreportmainList != null && labourreportmainList.size() > 0) {
			return R.error("当月数据已经存在,请删除旧数据重新添加或在旧数据上修改！");
		}
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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", labourreportmain.getCode());
		params.put("ext1", labourreportmain.getExt1());
		params.put("renderdate", labourreportmain.getRenderdate());
		List<LabourreportmainDO> labourreportmainList = labourreportmainService
				.getByCondition(params);
		if (labourreportmainList != null && labourreportmainList.size() > 0) {
			if (labourreportmainList.size() == 1) {
				if (!labourreportmainList.get(0).getOid()
						.equals(labourreportmain.getOid()))
					return R.error("当月数据已经存在,请删除旧数据重新添加或在旧数据上修改！");
			} else {
				return R.error("当月数据已经存在,请删除旧数据重新添加或在旧数据上修改！");
			}
		}
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

	@GetMapping("/cancelapprove")
	@RequiresPermissions("system:labourreportmain:approve")
	public String cancelapprove(String oid, Model model) {
		model.addAttribute("foid", oid);
		return "system/labourreportmain/cancelapprove";
	}

	@ResponseBody
	@PostMapping("/saveapprove")
	@RequiresPermissions(value = { "system:labourreportmain:sumitinfo",
			"system:labourreportmain:approve",
			"system:labourreportstaticmain:sumitinfo" }, logical = Logical.OR)
	public R saveapprove(String oid, Integer status, String remark, Model model) {
		LabourreportmainDO labourreportmain = new LabourreportmainDO();
		labourreportmain.setOid(oid);
		labourreportmain.setStatus(status);
		// if (labourreportmain.getStatus().equals(3)) // 审批不通过，则需要重新校验
		// {
		// labourreportmain.setExt3("0");
		// }
		int result = labourreportmainService.update(labourreportmain);
		if (result > 0) {
			Long uid = getUserId();
			String pkey = UUID.randomUUID().toString().replace("-", "");
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

	@ResponseBody
	@GetMapping("/listdept")
	@RequiresPermissions("system:labourreportmain:labourreportmaindept")
	public List<DeptDO> listdept(@RequestParam Map<String, Object> params,
			@RequestParam(value = "status[]", required = false) String[] status) {
		if (params.containsKey("status[]"))
			params.remove("status[]");
		if (status != null && status.length > 0)
			params.put("status", status);
		List<DeptDO> list = labourreportmainService.listdept(params);
		return list;
	}

	@GetMapping("/dept")
	@RequiresPermissions("system:labourreportmain:labourreportmaindept")
	String Labourreportmaindept(Model model) {
		return "system/labourreportmain/labourreportmaindept";
	}

	@PostMapping("/batchApprove")
	@ResponseBody
	@RequiresPermissions("system:labourreportmain:batchApprove")
	public R batchApprove(@RequestParam("ids[]") String[] oids, String remark,
			Integer status) {
		String ext3 = "0";
		if (status.equals(3)) {
			ext3 = "0";
		} else {
			ext3 = "1";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oids", oids);
		map.put("status", status);
		map.put("ext3", ext3);
		int result = labourreportmainService.batchApprove(map);
		if (result > 0) {
			if (StringUtils.isEmpty(remark))
				remark = status.equals(3) ? "审核不通过" : "审核通过";
			Long uid = getUserId();
			List<LabourrepotapproveDO> list = new ArrayList<LabourrepotapproveDO>();
			for (String fid : oids) {
				String pkey = UUID.randomUUID().toString().replace("-", "");
				LabourrepotapproveDO labourrepotapprove = new LabourrepotapproveDO();
				labourrepotapprove.setOid(pkey);
				labourrepotapprove.setFoid(fid);
				labourrepotapprove.setContent(remark);
				labourrepotapprove.setStatus(status);
				labourrepotapprove.setUptuser(uid.toString());
				list.add(labourrepotapprove);
			}
			result = labourrepotapproveService.insertlist(list);
			if (result > 0) {
				return R.ok();
			}
		}
		return R.error("处理数据失败");
	}
}
