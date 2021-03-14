package com.bootdo.system.service;

import com.bootdo.system.domain.KbDeptDO;
import com.bootdo.system.domain.SortKbDeptDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-19 21:38:56
 */
public interface KbDeptService {

	KbDeptDO get(Integer oid);

	List<KbDeptDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(KbDeptDO kbDept);

	int update(KbDeptDO kbDept);

	int remove(Integer oid);

	int batchRemove(Integer[] oids);

	List<KbDeptDO> listnew(Integer foid);
	
	List<SortKbDeptDO> sortlist(Integer foid);
	
	int updatelist(List<SortKbDeptDO> deptIds);
}
