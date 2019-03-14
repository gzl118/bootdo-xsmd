package com.bootdo.system.publish.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.LabourreportmainDO;
import com.bootdo.system.domain.LabourrepotapproveDO;
import com.bootdo.system.service.LabourreportmainService;
import com.bootdo.system.service.LabourrepotapproveService;

@RestController
@RequestMapping("/publish/out")
public class OutController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private LabourreportmainService labourreportmainService;
	@Autowired
	private LabourrepotapproveService labourrepotapproveService;

	@Log("保存提交信息")
	@PostMapping("/saveapprove")
	@ApiOperation(value = "保存提交信息", notes = "保存提交信息")
	@ApiResponses({ @ApiResponse(response = R.class, code = 200, message = "返回结构:R.class") })
	public R saveapprove(String oid, Integer status, Integer uid, String remark) {
		LabourreportmainDO labourreportmain = new LabourreportmainDO();
		labourreportmain.setOid(oid);
		labourreportmain.setStatus(status);
		int result = labourreportmainService.update(labourreportmain);
		if (result > 0) {
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

	@Log("保存校验结果")
	@PostMapping("/savecheck")
	@ApiOperation(value = "保存校验结果", notes = "保存校验结果")
	@ApiResponses({ @ApiResponse(response = R.class, code = 200, message = "返回结构:R.class") })
	public R savecheck(String oid, Integer status) {
		LabourreportmainDO m = labourreportmainService.get(oid);
		if (m.getExt3().equals("2") && status == 3) {
			status = 1;
		} else if (m.getExt3().equals("3") && status == 2) {
			status = 1;
		}
		LabourreportmainDO labourreportmain = new LabourreportmainDO();
		labourreportmain.setOid(oid);
		labourreportmain.setExt3(status.toString());
		int result = labourreportmainService.update(labourreportmain);
		if (result > 0) {
			return R.ok();
		}
		return R.error();
	}
}
