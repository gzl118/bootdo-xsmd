package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.KbGroupDao;
import com.bootdo.system.domain.KbGroupDO;
import com.bootdo.system.service.KbGroupService;



@Service
public class KbGroupServiceImpl implements KbGroupService {
	@Autowired
	private KbGroupDao kbGroupDao;
	
	@Override
	public KbGroupDO get(String oid){
		return kbGroupDao.get(oid);
	}
	
	@Override
	public List<KbGroupDO> list(Map<String, Object> map){
		return kbGroupDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return kbGroupDao.count(map);
	}
	
	@Override
	public int save(KbGroupDO kbGroup){
		return kbGroupDao.save(kbGroup);
	}
	
	@Override
	public int update(KbGroupDO kbGroup){
		return kbGroupDao.update(kbGroup);
	}
	
	@Override
	public int remove(String oid){
		return kbGroupDao.remove(oid);
	}
	
	@Override
	public int batchRemove(String[] oids){
		return kbGroupDao.batchRemove(oids);
	}
	
}
