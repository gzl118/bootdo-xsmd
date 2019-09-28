package com.bootdo.system.dao;

import com.bootdo.system.domain.LabouryearplanDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-09-27 21:24:41
 */
@Mapper
public interface LabouryearplanDao {

	LabouryearplanDO get(String oid);
	
	List<LabouryearplanDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LabouryearplanDO labouryearplan);
	
	int update(LabouryearplanDO labouryearplan);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
	
	int addPlan (LabouryearplanDO labouryearplan);
}
