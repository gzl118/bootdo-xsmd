package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.KbDeptDao;
import com.bootdo.system.domain.KbDeptDO;
import com.bootdo.system.service.KbDeptService;

@Service
public class KbDeptServiceImpl implements KbDeptService {
	@Autowired
	private KbDeptDao kbDeptDao;

	@Override
	public KbDeptDO get(Integer oid) {
		return kbDeptDao.get(oid);
	}

	@Override
	public List<KbDeptDO> list(Map<String, Object> map) {
		return kbDeptDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return kbDeptDao.count(map);
	}

	@Override
	public int save(KbDeptDO kbDept) {
		return kbDeptDao.save(kbDept);
	}

	@Override
	public int update(KbDeptDO kbDept) {
		return kbDeptDao.update(kbDept);
	}

	@Override
	public int remove(Integer oid) {
		return kbDeptDao.remove(oid);
	}

	@Override
	public int batchRemove(Integer[] oids) {
		return kbDeptDao.batchRemove(oids);
	}

	@Override
	public List<KbDeptDO> listnew(Integer foid) {
		return kbDeptDao.listnew(foid);
	}
}
