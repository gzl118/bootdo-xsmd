package com.bootdo.system.service;

import com.bootdo.system.domain.ReportAutoconfigmainDO;

import java.util.List;
import java.util.Map;

/**
 * 自定义报表配置主表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:11:11
 */
public interface ReportAutoconfigmainService {
	
	ReportAutoconfigmainDO get(String oid);
	
	List<ReportAutoconfigmainDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReportAutoconfigmainDO reportAutoconfigmain);
	
	int update(ReportAutoconfigmainDO reportAutoconfigmain);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
}
