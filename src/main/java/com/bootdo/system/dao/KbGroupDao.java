package com.bootdo.system.dao;

import com.bootdo.system.domain.KbGroupDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-19 21:38:56
 */
@Mapper
public interface KbGroupDao {

	KbGroupDO get(String oid);
	
	List<KbGroupDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(KbGroupDO kbGroup);
	
	int update(KbGroupDO kbGroup);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
}
