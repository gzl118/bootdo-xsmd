package com.bootdo.system.service;

import com.bootdo.system.domain.LabourrepotapproveDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-18 15:05:33
 */
public interface LabourrepotapproveService {
	
	LabourrepotapproveDO get(String oid);
	
	List<LabourrepotapproveDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LabourrepotapproveDO labourrepotapprove);
	
	int update(LabourrepotapproveDO labourrepotapprove);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
}
