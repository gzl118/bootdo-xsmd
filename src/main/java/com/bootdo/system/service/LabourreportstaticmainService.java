package com.bootdo.system.service;

import com.bootdo.system.domain.LabourreportstaticmainDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-06 09:30:46
 */
public interface LabourreportstaticmainService {

	LabourreportstaticmainDO get(String oid);

	List<LabourreportstaticmainDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(LabourreportstaticmainDO labourreportstaticmain);

	int update(LabourreportstaticmainDO labourreportstaticmain);

	int remove(String oid);

	int batchRemove(String[] oids);

	List<LabourreportstaticmainDO> listnew(Map<String, Object> map);

	LabourreportstaticmainDO getnew(String oid);

	String extcutekbdetail(String oid);

	int removekbdetial(String oid);

	List<LabourreportstaticmainDO> listexport(Map<String, Object> map);
	
	String extcuteplandetail(String oid);
}
