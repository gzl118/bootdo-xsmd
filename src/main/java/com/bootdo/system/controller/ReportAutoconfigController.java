package com.bootdo.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.ReportAutoconfigDO;
import com.bootdo.system.service.ReportAutoconfigService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-02 18:32:08
 */

@Controller
@RequestMapping("/system/reportAutoconfig")
public class ReportAutoconfigController extends BaseController {
	@Autowired
	private ReportAutoconfigService reportAutoconfigService;

	@GetMapping()
	@RequiresPermissions("system:reportAutoconfig:reportAutoconfig")
	String ReportAutoconfig() {
		return "system/reportAutoconfig/reportAutoconfig";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:reportAutoconfig:reportAutoconfig")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ReportAutoconfigDO> reportAutoconfigList = reportAutoconfigService
				.list(query);
		int total = reportAutoconfigService.count(query);
		PageUtils pageUtils = new PageUtils(reportAutoconfigList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:reportAutoconfig:add")
	String add() {
		return "system/reportAutoconfig/add";
	}

	@GetMapping("/edit/{oid}")
	@RequiresPermissions("system:reportAutoconfig:edit")
	String edit(@PathVariable("oid") String oid, Model model) {
		ReportAutoconfigDO reportAutoconfig = reportAutoconfigService.get(oid);
		model.addAttribute("reportAutoconfig", reportAutoconfig);
		return "system/reportAutoconfig/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:reportAutoconfig:add")
	public R save(ReportAutoconfigDO reportAutoconfig) {
		if (reportAutoconfigService.save(reportAutoconfig) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:reportAutoconfig:edit")
	public R update(ReportAutoconfigDO reportAutoconfig) {
		reportAutoconfigService.update(reportAutoconfig);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:reportAutoconfig:remove")
	public R remove(String oid) {
		if (reportAutoconfigService.remove(oid) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:reportAutoconfig:batchRemove")
	public R remove(@RequestParam("ids[]") String[] oids) {
		reportAutoconfigService.batchRemove(oids);
		return R.ok();
	}

	@RequestMapping(value = "saveconfig", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public Map<String, String> saveconfig(String sjson, String foid,
			HttpServletRequest request, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST");
		response.addHeader("Access-Control-Max-Age", "1000");
		Map<String, String> map = new HashMap<String, String>();
		try {
			Long uid = getUserId();
			List<ReportAutoconfigDO> list = JSON.parseArray(sjson,
					ReportAutoconfigDO.class);
			// String foid = list.get(0).getFoid();
			reportAutoconfigService.removebyfk(foid);
			if (list.size() > 0) {
				list.stream().forEach(p -> {
					p.setOid(UUID.randomUUID().toString().replace("-", ""));
					p.setUptuser(uid.toString());
				});
				if (reportAutoconfigService.savelist(list) > 0)
					map.put("message", "1");
				else
					map.put("message", "0");
			} else {
				map.put("message", "1");
			}
		} catch (Exception e) {
			map.put("message", "0");
		}
		return map;
	}

	@ResponseBody
	@GetMapping("/listbyfk")
	public List<ReportAutoconfigDO> listbyfk(String foid) {
		List<ReportAutoconfigDO> reportAutoconfigList = reportAutoconfigService
				.listbyfk(foid);
		return reportAutoconfigList;
	}
}
