package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.ReportAutoconfigmainDao;
import com.bootdo.system.domain.ReportAutoconfigmainDO;
import com.bootdo.system.service.ReportAutoconfigmainService;



@Service
public class ReportAutoconfigmainServiceImpl implements ReportAutoconfigmainService {
	@Autowired
	private ReportAutoconfigmainDao reportAutoconfigmainDao;
	
	@Override
	public ReportAutoconfigmainDO get(String oid){
		return reportAutoconfigmainDao.get(oid);
	}
	
	@Override
	public List<ReportAutoconfigmainDO> list(Map<String, Object> map){
		return reportAutoconfigmainDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reportAutoconfigmainDao.count(map);
	}
	
	@Override
	public int save(ReportAutoconfigmainDO reportAutoconfigmain){
		return reportAutoconfigmainDao.save(reportAutoconfigmain);
	}
	
	@Override
	public int update(ReportAutoconfigmainDO reportAutoconfigmain){
		return reportAutoconfigmainDao.update(reportAutoconfigmain);
	}
	
	@Override
	public int remove(String oid){
		return reportAutoconfigmainDao.remove(oid);
	}
	
	@Override
	public int batchRemove(String[] oids){
		return reportAutoconfigmainDao.batchRemove(oids);
	}
	
}
