package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gzl
 *
 */
public class SortKbDeptDO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//oid
	private Integer oid;
	//外键
	private Integer foid;
	//部门编号
	private String deptId;
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
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getFoid() {
		return foid;
	}
	public void setFoid(Integer foid) {
		this.foid = foid;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptGroupId() {
		return deptGroupId;
	}
	public void setDeptGroupId(String deptGroupId) {
		this.deptGroupId = deptGroupId;
	}
	public Integer getNorder() {
		return norder;
	}
	public void setNorder(Integer norder) {
		this.norder = norder;
	}
	public Integer getNtype() {
		return ntype;
	}
	public void setNtype(Integer ntype) {
		this.ntype = ntype;
	}
	public String getUptuser() {
		return uptuser;
	}
	public void setUptuser(String uptuser) {
		this.uptuser = uptuser;
	}
	public Date getUpttime() {
		return upttime;
	}
	public void setUpttime(Date upttime) {
		this.upttime = upttime;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

}
