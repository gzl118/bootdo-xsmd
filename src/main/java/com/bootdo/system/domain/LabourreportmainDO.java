package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-11 13:33:34
 */
public class LabourreportmainDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String oid;
	//编号
	private String code;
	//填报单位
	private String renderdepart;
	//汇报时间
	private String renderdate;
	//状态,0未提交，1已提交，2已审核通过，3审核未通过
	private Integer status;
	//矿负责人
	private String mineleader;
	//业务部门负责人
	private String businessleader;
	//制表人
	private String edituser;
	//制表时间
	private Date edittime;
	//更新时间
	private Date upttime;
	//操作人
	private String uptuser;
	//说明
	private String remark;
	//备用1
	private String ext1;
	//备用2
	private String ext2;
	//备用3
	private String ext3;

	/**
	 * 设置：主键
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	/**
	 * 获取：主键
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * 设置：编号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：编号
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：填报单位
	 */
	public void setRenderdepart(String renderdepart) {
		this.renderdepart = renderdepart;
	}
	/**
	 * 获取：填报单位
	 */
	public String getRenderdepart() {
		return renderdepart;
	}
	/**
	 * 设置：汇报时间
	 */
	public void setRenderdate(String renderdate) {
		this.renderdate = renderdate;
	}
	/**
	 * 获取：汇报时间
	 */
	public String getRenderdate() {
		return renderdate;
	}
	/**
	 * 设置：状态,0未提交，1已提交，2已审核通过，3审核未通过
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态,0未提交，1已提交，2已审核通过，3审核未通过
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：矿负责人
	 */
	public void setMineleader(String mineleader) {
		this.mineleader = mineleader;
	}
	/**
	 * 获取：矿负责人
	 */
	public String getMineleader() {
		return mineleader;
	}
	/**
	 * 设置：业务部门负责人
	 */
	public void setBusinessleader(String businessleader) {
		this.businessleader = businessleader;
	}
	/**
	 * 获取：业务部门负责人
	 */
	public String getBusinessleader() {
		return businessleader;
	}
	/**
	 * 设置：制表人
	 */
	public void setEdituser(String edituser) {
		this.edituser = edituser;
	}
	/**
	 * 获取：制表人
	 */
	public String getEdituser() {
		return edituser;
	}
	/**
	 * 设置：制表时间
	 */
	public void setEdittime(Date edittime) {
		this.edittime = edittime;
	}
	/**
	 * 获取：制表时间
	 */
	public Date getEdittime() {
		return edittime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpttime(Date upttime) {
		this.upttime = upttime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpttime() {
		return upttime;
	}
	/**
	 * 设置：操作人
	 */
	public void setUptuser(String uptuser) {
		this.uptuser = uptuser;
	}
	/**
	 * 获取：操作人
	 */
	public String getUptuser() {
		return uptuser;
	}
	/**
	 * 设置：说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：说明
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：备用1
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	/**
	 * 获取：备用1
	 */
	public String getExt1() {
		return ext1;
	}
	/**
	 * 设置：备用2
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	/**
	 * 获取：备用2
	 */
	public String getExt2() {
		return ext2;
	}
	/**
	 * 设置：备用3
	 */
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	/**
	 * 获取：备用3
	 */
	public String getExt3() {
		return ext3;
	}
}
