package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.ReportAutoconfigDao;
import com.bootdo.system.domain.ReportAutoconfigDO;
import com.bootdo.system.service.ReportAutoconfigService;

@Service
public class ReportAutoconfigServiceImpl implements ReportAutoconfigService {
	@Autowired
	private ReportAutoconfigDao reportAutoconfigDao;

	@Override
	public ReportAutoconfigDO get(String oid) {
		return reportAutoconfigDao.get(oid);
	}

	@Override
	public List<ReportAutoconfigDO> list(Map<String, Object> map) {
		return reportAutoconfigDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return reportAutoconfigDao.count(map);
	}

	@Override
	public int save(ReportAutoconfigDO reportAutoconfig) {
		return reportAutoconfigDao.save(reportAutoconfig);
	}

	@Override
	public int update(ReportAutoconfigDO reportAutoconfig) {
		return reportAutoconfigDao.update(reportAutoconfig);
	}

	@Override
	public int remove(String oid) {
		return reportAutoconfigDao.remove(oid);
	}

	@Override
	public int batchRemove(String[] oids) {
		return reportAutoconfigDao.batchRemove(oids);
	}

	@Override
	public int savelist(List<ReportAutoconfigDO> list) {
		return reportAutoconfigDao.savelist(list);
	}

	@Override
	public int removebyfk(String foid) {
		return reportAutoconfigDao.removebyfk(foid);
	}

	@Override
	public List<ReportAutoconfigDO> listbyfk(String foid) {
		return reportAutoconfigDao.listbyfk(foid);
	}
}
