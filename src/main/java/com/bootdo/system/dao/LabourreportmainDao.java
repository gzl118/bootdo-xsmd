package com.bootdo.system.dao;

import com.bootdo.system.domain.LabourreportmainDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-11 13:33:34
 */
@Mapper
public interface LabourreportmainDao {

	LabourreportmainDO get(String oid);
	
	List<LabourreportmainDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LabourreportmainDO labourreportmain);
	
	int update(LabourreportmainDO labourreportmain);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
	
	String getPkey(LabourreportmainDO labourreportmain);
	
	String delPkey(Map<String,Object> map);
}
