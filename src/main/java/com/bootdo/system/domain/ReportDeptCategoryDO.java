package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 报表部门配置分类
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-23 17:10:14
 */
public class ReportDeptCategoryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long rdcId;
	//分类名称
	private String name;
	//描述
	private String describe;
	//排序
	private Integer order;
	//是否删除  -1：已删除  0：正常
	private Integer flag;

	/**
	 * 设置：
	 */
	public void setRdcId(Long rdcId) {
		this.rdcId = rdcId;
	}
	/**
	 * 获取：
	 */
	public Long getRdcId() {
		return rdcId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：分类名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：描述
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * 获取：描述
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * 设置：排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * 设置：是否删除  -1：已删除  0：正常
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	public Integer getFlag() {
		return flag;
	}
}
