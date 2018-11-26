package com.bootdo.system.dao;

import com.bootdo.system.domain.ReportDeptDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 报表部门配置对应表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:08:28
 */
@Mapper
public interface ReportDeptDao {

	ReportDeptDO get(Long rdId);
	
	List<ReportDeptDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ReportDeptDO reportDept);
	
	int update(ReportDeptDO reportDept);
	
	int remove(Long rd_id);
	
	int removeByRdcId(Long rdcId);
	
	int batchRemove(Long[] rdIds);
	
	int batchSave(@Param("deptIds") Long[] deptIds, @Param("rdcId") Long  rdcId);
	
	
}
