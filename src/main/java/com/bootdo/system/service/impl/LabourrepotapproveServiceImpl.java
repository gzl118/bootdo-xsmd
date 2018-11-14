package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.LabourrepotapproveDao;
import com.bootdo.system.domain.LabourrepotapproveDO;
import com.bootdo.system.service.LabourrepotapproveService;



@Service
public class LabourrepotapproveServiceImpl implements LabourrepotapproveService {
	@Autowired
	private LabourrepotapproveDao labourrepotapproveDao;
	
	@Override
	public LabourrepotapproveDO get(String oid){
		return labourrepotapproveDao.get(oid);
	}
	
	@Override
	public List<LabourrepotapproveDO> list(Map<String, Object> map){
		return labourrepotapproveDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return labourrepotapproveDao.count(map);
	}
	
	@Override
	public int save(LabourrepotapproveDO labourrepotapprove){
		return labourrepotapproveDao.save(labourrepotapprove);
	}
	
	@Override
	public int update(LabourrepotapproveDO labourrepotapprove){
		return labourrepotapproveDao.update(labourrepotapprove);
	}
	
	@Override
	public int remove(String oid){
		return labourrepotapproveDao.remove(oid);
	}
	
	@Override
	public int batchRemove(String[] oids){
		return labourrepotapproveDao.batchRemove(oids);
	}
	
}
