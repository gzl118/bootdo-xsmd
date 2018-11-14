package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-18 15:05:33
 */
public class LabourrepotapproveDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String oid;
	//外键
	private String foid;
	//审批意见
	private String content;
	//状态:1已提交，2已审核通过，3审核未通过
	private Integer status;
	//更新时间
	private Date upttime;
	//操作人
	private String uptuser;
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
	 * 设置：外键
	 */
	public void setFoid(String foid) {
		this.foid = foid;
	}
	/**
	 * 获取：外键
	 */
	public String getFoid() {
		return foid;
	}
	/**
	 * 设置：审批意见
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：审批意见
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：状态:1已提交，2已审核通过，3审核未通过
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态:1已提交，2已审核通过，3审核未通过
	 */
	public Integer getStatus() {
		return status;
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
