package com.bootdo.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-09-27 21:24:41
 */
public class LabouryearplanDO implements Serializable {
	private static final long serialVersionUID = 1L;

	// 主键
	private String oid;
	// 年份
	private Integer nyear;
	// 单位ID
	private Long deptid;
	private String deptName;
	// 计划3
	private BigDecimal a3;
	// 计划2
	private BigDecimal a2;
	// 计划1
	private BigDecimal a1;
	// 计划4
	private BigDecimal a4;
	// 计划5
	private BigDecimal a5;
	// 计划6
	private BigDecimal a6;
	// 计划7
	private BigDecimal a7;
	// 计划8
	private BigDecimal a8;
	// 操作时间
	private Date upttime;
	// 备注
	private String ext1;
	// 备注
	private String ext2;

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
	 * 设置：年份
	 */
	public void setNyear(Integer nyear) {
		this.nyear = nyear;
	}

	/**
	 * 获取：年份
	 */
	public Integer getNyear() {
		return nyear;
	}

	/**
	 * 设置：单位ID
	 */
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	/**
	 * 获取：单位ID
	 */
	public Long getDeptid() {
		return deptid;
	}

	/**
	 * 设置：计划3
	 */
	public void setA3(BigDecimal a3) {
		this.a3 = a3;
	}

	/**
	 * 获取：计划3
	 */
	public BigDecimal getA3() {
		return a3;
	}

	/**
	 * 设置：计划2
	 */
	public void setA2(BigDecimal a2) {
		this.a2 = a2;
	}

	/**
	 * 获取：计划2
	 */
	public BigDecimal getA2() {
		return a2;
	}

	/**
	 * 设置：计划1
	 */
	public void setA1(BigDecimal a1) {
		this.a1 = a1;
	}

	/**
	 * 获取：计划1
	 */
	public BigDecimal getA1() {
		return a1;
	}

	/**
	 * 设置：计划4
	 */
	public void setA4(BigDecimal a4) {
		this.a4 = a4;
	}

	/**
	 * 获取：计划4
	 */
	public BigDecimal getA4() {
		return a4;
	}

	/**
	 * 设置：计划5
	 */
	public void setA5(BigDecimal a5) {
		this.a5 = a5;
	}

	/**
	 * 获取：计划5
	 */
	public BigDecimal getA5() {
		return a5;
	}

	/**
	 * 设置：计划6
	 */
	public void setA6(BigDecimal a6) {
		this.a6 = a6;
	}

	/**
	 * 获取：计划6
	 */
	public BigDecimal getA6() {
		return a6;
	}

	/**
	 * 设置：计划7
	 */
	public void setA7(BigDecimal a7) {
		this.a7 = a7;
	}

	/**
	 * 获取：计划7
	 */
	public BigDecimal getA7() {
		return a7;
	}

	/**
	 * 设置：计划8
	 */
	public void setA8(BigDecimal a8) {
		this.a8 = a8;
	}

	/**
	 * 获取：计划8
	 */
	public BigDecimal getA8() {
		return a8;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
