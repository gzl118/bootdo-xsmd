package com.bootdo.system.domain;

import java.io.Serializable;



/**
 * 报表部门配置对应表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:08:28
 */
public class ReportDeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long rdId;
	
	private Long deptId;
	//上级部门ID，一级部门为0
	private Long parentId;
	//部门简称
	private String sname;
	//排序
	private Integer orderNum;
	//归属分类
	private Long rdcId;

	/**
	 * 设置：
	 */
	public void setRdId(Long rdId) {
		this.rdId = rdId;
	}
	/**
	 * 获取：
	 */
	public Long getRdId() {
		return rdId;
	}
	/**
	 * 设置：上级部门ID，一级部门为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级部门ID，一级部门为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：部门简称
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * 获取：部门简称
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：归属分类
	 */
	public void setRdcId(Long rdcId) {
		this.rdcId = rdcId;
	}
	/**
	 * 获取：归属分类
	 */
	public Long getRdcId() {
		return rdcId;
	}
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
}
