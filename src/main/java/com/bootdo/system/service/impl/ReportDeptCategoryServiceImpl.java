package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.ReportDeptCategoryDao;
import com.bootdo.system.dao.ReportDeptDao;
import com.bootdo.system.domain.ReportDeptCategoryDO;
import com.bootdo.system.service.ReportDeptCategoryService;



@Service
public class ReportDeptCategoryServiceImpl implements ReportDeptCategoryService {
	@Autowired
	private ReportDeptCategoryDao reportDeptCategoryDao;
	@Autowired
	private ReportDeptDao reportDeptDao;
	
	@Override
	public ReportDeptCategoryDO get(Long rdcId){
		return reportDeptCategoryDao.get(rdcId);
	}
	
	@Override
	public List<ReportDeptCategoryDO> list(Map<String, Object> map){
		return reportDeptCategoryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reportDeptCategoryDao.count(map);
	}
	
	@Override
	public int save(ReportDeptCategoryDO reportDeptCategory){
		return reportDeptCategoryDao.save(reportDeptCategory);
	}
	
	@Override
	public int update(ReportDeptCategoryDO reportDeptCategory){
		return reportDeptCategoryDao.update(reportDeptCategory);
	}	
	
	@Override
	public int remove(Long rdcId){
		reportDeptDao.removeByRdcId(rdcId);
		return reportDeptCategoryDao.remove(rdcId);
	}
	
	@Override
	public int batchRemove(Long[] rdcIds){
		return reportDeptCategoryDao.batchRemove(rdcIds);
	}
	
}
