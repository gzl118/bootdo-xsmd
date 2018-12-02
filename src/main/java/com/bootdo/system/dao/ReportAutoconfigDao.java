package com.bootdo.system.dao;

import com.bootdo.system.domain.ReportAutoconfigDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-02 18:32:08
 */
@Mapper
public interface ReportAutoconfigDao {

	ReportAutoconfigDO get(String oid);

	List<ReportAutoconfigDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(ReportAutoconfigDO reportAutoconfig);

	int update(ReportAutoconfigDO reportAutoconfig);

	int remove(String oid);

	int batchRemove(String[] oids);

	int savelist(List<ReportAutoconfigDO> list);

	int removebyfk(String foid);
}
