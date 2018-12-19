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
public class KbDeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//oid
	private Integer oid;
	//外键
	private Integer foid;
	//部门编号
	private Integer deptId;
	//分组编号
	private String deptGroupId;
	//顺序
	private Integer norder;
	//类型，0集团本部，1股份公司
	private Integer ntype;
	//操作人
	private String uptuser;
	//操作时间
	private Date upttime;
	//备注
	private String ext1;
	//备注
	private String ext2;
	//备注
	private String ext3;

	/**
	 * 设置：oid
	 */
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	/**
	 * 获取：oid
	 */
	public Integer getOid() {
		return oid;
	}
	/**
	 * 设置：外键
	 */
	public void setFoid(Integer foid) {
		this.foid = foid;
	}
	/**
	 * 获取：外键
	 */
	public Integer getFoid() {
		return foid;
	}
	/**
	 * 设置：部门编号
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：部门编号
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * 设置：分组编号
	 */
	public void setDeptGroupId(String deptGroupId) {
		this.deptGroupId = deptGroupId;
	}
	/**
	 * 获取：分组编号
	 */
	public String getDeptGroupId() {
		return deptGroupId;
	}
	/**
	 * 设置：顺序
	 */
	public void setNorder(Integer norder) {
		this.norder = norder;
	}
	/**
	 * 获取：顺序
	 */
	public Integer getNorder() {
		return norder;
	}
	/**
	 * 设置：类型，0集团本部，1股份公司
	 */
	public void setNtype(Integer ntype) {
		this.ntype = ntype;
	}
	/**
	 * 获取：类型，0集团本部，1股份公司
	 */
	public Integer getNtype() {
		return ntype;
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
	/**
	 * 设置：备注
	 */
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	/**
	 * 获取：备注
	 */
	public String getExt1() {
		return ext1;
	}
	/**
	 * 设置：备注
	 */
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	/**
	 * 获取：备注
	 */
	public String getExt2() {
		return ext2;
	}
	/**
	 * 设置：备注
	 */
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	/**
	 * 获取：备注
	 */
	public String getExt3() {
		return ext3;
	}
}
