package com.bootdo.system.dao;

import com.bootdo.system.domain.ReportDeptCategoryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 报表部门配置分类
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:10:14
 */
@Mapper
public interface ReportDeptCategoryDao {

	ReportDeptCategoryDO get(Long rdcId);

	List<ReportDeptCategoryDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(ReportDeptCategoryDO reportDeptCategory);

	int update(ReportDeptCategoryDO reportDeptCategory);

	int remove(Long rdc_id);

	int removekb(Long rdc_id);

	int batchRemove(Long[] rdcIds);
}
