package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-19 21:38:56
 */
public class KbGroupDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//oid
	private String oid;
	//名称
	private String cname;
	//说明
	private String remark;
	//操作人
	private String uptuser;
	//操作时间
	private Date upttime;

	/**
	 * 设置：oid
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	/**
	 * 获取：oid
	 */
	public String getOid() {
		return oid;
	}
	/**
	 * 设置：名称
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * 获取：名称
	 */
	public String getCname() {
		return cname;
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
	 * 设置：操作时间
	 */
	public void setUpttime(Date upttime) {
		this.upttime = upttime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getUpttime() {
		return upttime;
	}
}
