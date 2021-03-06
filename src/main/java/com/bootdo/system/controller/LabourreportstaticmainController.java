package com.bootdo.system.controller;

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
import com.bootdo.system.domain.LabourreportstaticmainDO;
import com.bootdo.system.domain.LabourrepotapproveDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.LabourreportstaticmainService;
import com.bootdo.system.service.LabourrepotapproveService;
import com.bootdo.system.service.UserService;

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
	@Autowired
	UserService userService;

	@GetMapping()
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmain")
	String Labourreportstaticmain(String Code, Model model) {
		model.addAttribute("Code", Code);
		// model.addAttribute("Status", "");
		Integer result = CheckRole();
		model.addAttribute("Status", result);
		return "system/labourreportstaticmain/labourreportstaticmain";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmain")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		UserDO u = getUser();
		if(params.containsKey("ctype")){
			if (params.get("ctype").equals("5"))
				params.put("uptuser", u.getDeptId().toString());
		}
		// 查询列表数据
		Query query = new Query(params);
		List<LabourreportstaticmainDO> labourreportstaticmainList = labourreportstaticmainService
				.list(query);
		int total = labourreportstaticmainService.count(query);
		PageUtils pageUtils = new PageUtils(labourreportstaticmainList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	// @RequiresPermissions("system:labourreportstaticmain:add")
	String add(String rdate, String rdepart, String code, Integer ctype,
			String gname, Model model) {
		model.addAttribute("rdate", rdate);
		model.addAttribute("rdepart", rdepart);
		model.addAttribute("code", code);
		model.addAttribute("ctype", ctype);
		model.addAttribute("gname", gname);
		return "system/labourreportstaticmain/add";
	}

	@GetMapping("/addautoconfig")
	// @RequiresPermissions("system:labourreportstaticmain:addautoconfig")
	String addautoconfig(String rdate, String rdepart, String code,
			Integer ctype, String configid, Model model) {
		model.addAttribute("rdate", rdate);
		model.addAttribute("rdepart", rdepart);
		model.addAttribute("code", code);
		model.addAttribute("ctype", ctype);
		model.addAttribute("configid", configid);
		return "system/labourreportstaticmain/addautoconfig";
	}

	@GetMapping("/edit/{oid}")
	// @RequiresPermissions("system:labourreportstaticmain:edit")
	String edit(@PathVariable("oid") String oid, Model model) {
		LabourreportstaticmainDO labourreportstaticmain = labourreportstaticmainService
				.get(oid);
		model.addAttribute("labourreportstaticmain", labourreportstaticmain);
		return "system/labourreportstaticmain/edit";
	}

	@GetMapping("/editautoconfig/{oid}")
	// @RequiresPermissions("system:labourreportstaticmain:editautoconfig")
	String editautoconfig(@PathVariable("oid") String oid, Model model) {
		LabourreportstaticmainDO labourreportstaticmain = labourreportstaticmainService
				.get(oid);
		model.addAttribute("labourreportstaticmain", labourreportstaticmain);
		return "system/labourreportstaticmain/editautoconfig";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	// @RequiresPermissions("system:labourreportstaticmain:add")
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
			if (labourreportstaticmain.getCode().equals("30003")
					|| labourreportstaticmain.getCode().equals("30013")) {
				try {
					String foid = labourreportstaticmainService
							.extcuteplandetail(labourreportstaticmain.getOid());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	// @RequiresPermissions("system:labourreportstaticmain:edit")
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
	// @RequiresPermissions("system:labourreportstaticmain:remove")
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
	// @RequiresPermissions("system:labourreportstaticmain:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids) {
		labourreportstaticmainService.batchRemove(oids);
		return R.ok();
	}

	@GetMapping("/sumitinfo")
	// @RequiresPermissions("system:labourreportstaticmain:sumitinfo")
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

	@GetMapping("/labourreportautoconfigmain")
	@RequiresPermissions("system:labourreportstaticmain:labourreportautoconfigmain")
	String Labourreportautoconfigmain(String Code, Model model) {
		model.addAttribute("Code", Code);
		Integer result = CheckRole();
		model.addAttribute("Status", result);
		return "system/labourreportstaticmain/labourreportautoconfigmain";
	}

	@ResponseBody
	@GetMapping("/listautoconfig")
	@RequiresPermissions("system:labourreportstaticmain:labourreportautoconfigmain")
	public PageUtils listautoconfig(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<LabourreportstaticmainDO> labourreportstaticmainList = labourreportstaticmainService
				.list(query);
		int total = labourreportstaticmainService.count(query);
		PageUtils pageUtils = new PageUtils(labourreportstaticmainList, total);
		return pageUtils;
	}

	private Integer CheckRole() {
		Integer result = -1;
		Long id = getUserId();
		UserDO userDO = userService.get(id);
		List<Long> list = userDO.getRoleIds();
		if (list == null || list.size() == 0)
			return result;
		Long a = Long.valueOf(7);
		Long b = Long.valueOf(8);
		if (list.contains(a)) {
			return 7;
		}
		if (list.contains(b)) {
			return 8;
		}
		return result;
	}

	@GetMapping("/kb")
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmainkb")
	String Labourreportstaticmainkb(String Code, Model model) {
		model.addAttribute("Code", Code);
		Integer result = CheckRole();
		model.addAttribute("Status", result);
		return "system/labourreportstaticmain/labourreportstaticmainkb";
	}

	@ResponseBody
	@GetMapping("/listnew")
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmainkb")
	public PageUtils listnew(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<LabourreportstaticmainDO> labourreportstaticmainList = labourreportstaticmainService
				.listnew(query);
		int total = labourreportstaticmainService.count(query);
		PageUtils pageUtils = new PageUtils(labourreportstaticmainList, total);
		return pageUtils;
	}

	@GetMapping("/editkb/{oid}")
	// @RequiresPermissions("system:labourreportstaticmain:edit")
	String editkb(@PathVariable("oid") String oid, Model model) {
		LabourreportstaticmainDO labourreportstaticmain = labourreportstaticmainService
				.getnew(oid);
		model.addAttribute("labourreportstaticmain", labourreportstaticmain);
		return "system/labourreportstaticmain/editkb";
	}

	@GetMapping("/addkb")
	String addkb(String rdate, String rdepart, String code, Integer ctype,
			Model model) {
		model.addAttribute("rdate", rdate);
		model.addAttribute("rdepart", rdepart);
		model.addAttribute("code", code);
		model.addAttribute("ctype", ctype);
		return "system/labourreportstaticmain/addkb";
	}

	@ResponseBody
	@PostMapping("/savekb")
	public R savekb(LabourreportstaticmainDO labourreportstaticmain) {
		String noid = "";
		if (StringUtils.isEmpty(labourreportstaticmain.getOid()))
			noid = UUID.randomUUID().toString().replace("-", "");
		labourreportstaticmain.setOid(noid);
		if (!StringUtils.isEmpty(labourreportstaticmain.getRenderdate()))
			labourreportstaticmain.setRenderdate(labourreportstaticmain
					.getRenderdate() + "-01");
		Long uid = getUserId();
		labourreportstaticmain.setUptuser(uid.toString());
		if (labourreportstaticmainService.save(labourreportstaticmain) > 0) {
			String foid = labourreportstaticmainService.extcutekbdetail(noid);
			if (!StringUtils.isEmpty(foid))
				return R.ok();
			return R.error();
		}
		return R.error();
	}

	@PostMapping("/removekb")
	@ResponseBody
	public R removekb(String oid) {
		if (labourreportstaticmainService.remove(oid) > 0) {
			if (labourreportstaticmainService.removekbdetial(oid) > 0)
				return R.ok();
			return R.error();
		}
		return R.error();
	}

	@GetMapping("/export")
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmainexport")
	String Labourreportstaticmainexport(Model model) {
		return "system/labourreportstaticmain/labourreportstaticmainexport";
	}

	@ResponseBody
	@GetMapping("/listexport")
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmainexport")
	public PageUtils listexport(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<LabourreportstaticmainDO> labourreportstaticmainList = labourreportstaticmainService
				.listexport(query);
		int total = labourreportstaticmainService.count(query);
		PageUtils pageUtils = new PageUtils(labourreportstaticmainList, total);
		return pageUtils;
	}

	@GetMapping("/labouryearreportmain")
	@RequiresPermissions("system:labourreportstaticmain:labourreportstaticmain")
	String Labouryearreportmain(String Code, String ctype, Model model) {
		model.addAttribute("Code", Code);
		model.addAttribute("ctype", ctype);
		Integer result = CheckRole();
		Long id = getUserId();
		model.addAttribute("Status", result);
		model.addAttribute("uid", id);
		return "system/labourreportmain/labouryearreportmain";
	}
}
