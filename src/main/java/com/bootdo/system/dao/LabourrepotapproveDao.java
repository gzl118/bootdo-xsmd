package com.bootdo.system.dao;

import com.bootdo.system.domain.LabourrepotapproveDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-18 15:05:33
 */
@Mapper
public interface LabourrepotapproveDao {

	LabourrepotapproveDO get(String oid);
	
	List<LabourrepotapproveDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LabourrepotapproveDO labourrepotapprove);
	
	int update(LabourrepotapproveDO labourrepotapprove);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
}
