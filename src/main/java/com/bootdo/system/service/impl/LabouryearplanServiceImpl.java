package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.LabouryearplanDao;
import com.bootdo.system.domain.LabouryearplanDO;
import com.bootdo.system.service.LabouryearplanService;

@Service
public class LabouryearplanServiceImpl implements LabouryearplanService {
	@Autowired
	private LabouryearplanDao labouryearplanDao;

	@Override
	public LabouryearplanDO get(String oid) {
		return labouryearplanDao.get(oid);
	}

	@Override
	public List<LabouryearplanDO> list(Map<String, Object> map) {
		return labouryearplanDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return labouryearplanDao.count(map);
	}

	@Override
	public int save(LabouryearplanDO labouryearplan) {
		return labouryearplanDao.save(labouryearplan);
	}

	@Override
	public int update(LabouryearplanDO labouryearplan) {
		return labouryearplanDao.update(labouryearplan);
	}

	@Override
	public int remove(String oid) {
		return labouryearplanDao.remove(oid);
	}

	@Override
	public int batchRemove(String[] oids) {
		return labouryearplanDao.batchRemove(oids);
	}

	@Override
	public int addPlan(LabouryearplanDO labouryearplan) {
		return labouryearplanDao.addPlan(labouryearplan);
	}
}
