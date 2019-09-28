package com.bootdo.system.service;

import com.bootdo.system.domain.LabouryearplanDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-09-27 21:24:41
 */
public interface LabouryearplanService {
	
	LabouryearplanDO get(String oid);
	
	List<LabouryearplanDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LabouryearplanDO labouryearplan);
	
	int update(LabouryearplanDO labouryearplan);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
	
	int addPlan (LabouryearplanDO labouryearplan);
}
