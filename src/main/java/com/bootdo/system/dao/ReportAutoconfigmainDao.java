package com.bootdo.system.dao;

import com.bootdo.system.domain.ReportAutoconfigmainDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 自定义报表配置主表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:11:11
 */
@Mapper
public interface ReportAutoconfigmainDao {

	ReportAutoconfigmainDO get(String oid);
	
	List<ReportAutoconfigmainDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ReportAutoconfigmainDO reportAutoconfigmain);
	
	int update(ReportAutoconfigmainDO reportAutoconfigmain);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
}
