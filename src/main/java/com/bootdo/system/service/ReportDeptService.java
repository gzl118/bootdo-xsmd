package com.bootdo.system.service;

import com.bootdo.system.domain.ReportDeptDO;

import java.util.List;
import java.util.Map;

/**
 * 报表部门配置对应表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:08:28
 */
public interface ReportDeptService {
	
	ReportDeptDO get(Long rdId);
	
	List<ReportDeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReportDeptDO reportDept);
	
	int update(ReportDeptDO reportDept);
	
	int remove(Long rdId);
	
	int batchRemove(Long[] rdIds);
	
	int batchSave(Long[] deptIds, Long  rdcId);
	
	List<Long> getDeptsByRdcId(Long rdcId);
}
