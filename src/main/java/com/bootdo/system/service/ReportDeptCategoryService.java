package com.bootdo.system.service;

import com.bootdo.system.domain.ReportDeptCategoryDO;

import java.util.List;
import java.util.Map;

/**
 * 报表部门配置分类
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:10:14
 */
public interface ReportDeptCategoryService {
	
	ReportDeptCategoryDO get(Long rdcId);
	
	List<ReportDeptCategoryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReportDeptCategoryDO reportDeptCategory);

	int saveCategoryAndDepts(ReportDeptCategoryDO reportDeptCategory,Long[] deptIds);
	
	int update(ReportDeptCategoryDO reportDeptCategory);

	int remove(Long rdcId);
	
	int batchRemove(Long[] rdcIds);
	
	int removekb(Long rdc_id);
}
