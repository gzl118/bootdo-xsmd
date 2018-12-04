package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.system.dao.ReportDeptDao;
import com.bootdo.system.domain.ReportDeptDO;
import com.bootdo.system.service.ReportDeptService;



@Service
public class ReportDeptServiceImpl implements ReportDeptService {
	@Autowired
	private ReportDeptDao reportDeptDao;
	
	@Override
	public ReportDeptDO get(Long rdId){
		return reportDeptDao.get(rdId);
	}
	
	@Override
	public List<ReportDeptDO> list(Map<String, Object> map){
		return reportDeptDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reportDeptDao.count(map);
	}
	
	@Override
	public int save(ReportDeptDO reportDept){
		return reportDeptDao.save(reportDept);
	}
	
	@Override
	public int update(ReportDeptDO reportDept){
		return reportDeptDao.update(reportDept);
	}
	
	@Override
	public int remove(Long rdId){
		return reportDeptDao.remove(rdId);
	}
	
	@Override
	public int batchRemove(Long[] rdIds){
		return reportDeptDao.batchRemove(rdIds);
	}
	
	@Override
	public int batchSave(Long[] deptIds, Long  rdcId){
		// TODO Auto-generated method stub
		return reportDeptDao.batchSave(deptIds,rdcId);
	}
	
	@Override
	public List<Long> getDeptsByRdcId(Long rdcId){
		return reportDeptDao.getDeptsByRdcId(rdcId);
	}
}
