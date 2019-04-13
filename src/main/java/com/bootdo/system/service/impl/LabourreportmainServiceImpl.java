package com.bootdo.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.system.dao.LabourreportmainDao;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.domain.LabourreportmainDO;
import com.bootdo.system.service.LabourreportmainService;

@Service
public class LabourreportmainServiceImpl implements LabourreportmainService {
	@Autowired
	private LabourreportmainDao labourreportmainDao;

	@Override
	public LabourreportmainDO get(String oid) {
		return labourreportmainDao.get(oid);
	}

	@Override
	public List<LabourreportmainDO> list(Map<String, Object> map) {
		return labourreportmainDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return labourreportmainDao.count(map);
	}

	@Override
	public int save(LabourreportmainDO labourreportmain) {
		return labourreportmainDao.save(labourreportmain);
	}

	@Override
	public int update(LabourreportmainDO labourreportmain) {
		return labourreportmainDao.update(labourreportmain);
	}

	@Override
	public int remove(String oid) {
		return labourreportmainDao.remove(oid);
	}

	@Override
	public int batchRemove(String[] oids) {
		return labourreportmainDao.batchRemove(oids);
	}

	@Override
	public String getPkey(LabourreportmainDO labourreportmain) {
		return labourreportmainDao.getPkey(labourreportmain);
	}

	@Override
	public String delPkey(Map<String, Object> map) {
		return labourreportmainDao.delPkey(map);
	}

	@Override
	public List<DeptDO> listdept(Map<String, Object> map)

	{
		return labourreportmainDao.listdept(map);
	}

	@Override
	public List<LabourreportmainDO> getByCondition(Map<String, Object> map) {
		return labourreportmainDao.getByCondition(map);
	}

	@Override
	public int batchApprove(Map<String, Object> map) {
		return labourreportmainDao.batchApprove(map);
	}
}
