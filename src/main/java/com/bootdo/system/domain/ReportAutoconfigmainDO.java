package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 自定义报表配置主表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-08 11:11:11
 */
public class ReportAutoconfigmainDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String oid;
	//名称
	private String tname;
	//描述
	private String configdesc;
	//序号
	private Integer norder;
	//标识，0可用，1不可用
	private Integer flag;
	//编号
	private String code;
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
	 * 设置：名称
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
	/**
	 * 获取：名称
	 */
	public String getTname() {
		return tname;
	}
	/**
	 * 设置：描述
	 */
	public void setConfigdesc(String configdesc) {
		this.configdesc = configdesc;
	}
	/**
	 * 获取：描述
	 */
	public String getConfigdesc() {
		return configdesc;
	}
	/**
	 * 设置：序号
	 */
	public void setNorder(Integer norder) {
		this.norder = norder;
	}
	/**
	 * 获取：序号
	 */
	public Integer getNorder() {
		return norder;
	}
	/**
	 * 设置：标识，0可用，1不可用
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：标识，0可用，1不可用
	 */
	public Integer getFlag() {
		return flag;
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
