package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.LabourreportstaticmainDao;
import com.bootdo.system.domain.LabourreportstaticmainDO;
import com.bootdo.system.service.LabourreportstaticmainService;

@Service
public class LabourreportstaticmainServiceImpl implements
		LabourreportstaticmainService {
	@Autowired
	private LabourreportstaticmainDao labourreportstaticmainDao;

	@Override
	public LabourreportstaticmainDO get(String oid) {
		return labourreportstaticmainDao.get(oid);
	}

	@Override
	public List<LabourreportstaticmainDO> list(Map<String, Object> map) {
		return labourreportstaticmainDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return labourreportstaticmainDao.count(map);
	}

	@Override
	public int save(LabourreportstaticmainDO labourreportstaticmain) {
		return labourreportstaticmainDao.save(labourreportstaticmain);
	}

	@Override
	public int update(LabourreportstaticmainDO labourreportstaticmain) {
		return labourreportstaticmainDao.update(labourreportstaticmain);
	}

	@Override
	public int remove(String oid) {
		return labourreportstaticmainDao.remove(oid);
	}

	@Override
	public int batchRemove(String[] oids) {
		return labourreportstaticmainDao.batchRemove(oids);
	}

	@Override
	public List<LabourreportstaticmainDO> listnew(Map<String, Object> map) {
		return labourreportstaticmainDao.listnew(map);
	}

	@Override
	public LabourreportstaticmainDO getnew(String oid) {
		return labourreportstaticmainDao.getnew(oid);
	}
}
