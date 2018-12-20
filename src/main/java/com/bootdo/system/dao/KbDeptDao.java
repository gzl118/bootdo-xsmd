package com.bootdo.system.dao;

import com.bootdo.system.domain.KbDeptDO;

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
public interface KbDeptDao {

	KbDeptDO get(Integer oid);

	List<KbDeptDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(KbDeptDO kbDept);

	int update(KbDeptDO kbDept);

	int remove(Integer oid);

	int batchRemove(Integer[] oids);

	List<KbDeptDO> listnew(Integer foid);
}
