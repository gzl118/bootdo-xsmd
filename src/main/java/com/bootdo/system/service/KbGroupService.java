package com.bootdo.system.service;

import com.bootdo.system.domain.KbGroupDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-19 21:38:56
 */
public interface KbGroupService {
	
	KbGroupDO get(String oid);
	
	List<KbGroupDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(KbGroupDO kbGroup);
	
	int update(KbGroupDO kbGroup);
	
	int remove(String oid);
	
	int batchRemove(String[] oids);
}
