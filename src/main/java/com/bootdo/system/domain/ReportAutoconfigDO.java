package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-12-02 18:32:08
 */
public class ReportAutoconfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String oid;
	//外键
	private String foid;
	//表名
	private String tbname;
	//报表的行标识
	private Integer rowoid;
	//选择的列名称
	private String colfieldname;
	//组合后的列标题
	private String colname;
	//列别名
	private String colaliasname;
	//列显示顺序
	private Integer colorder;
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
	 * 设置：表名
	 */
	public void setTbname(String tbname) {
		this.tbname = tbname;
	}
	/**
	 * 获取：表名
	 */
	public String getTbname() {
		return tbname;
	}
	/**
	 * 设置：报表的行标识
	 */
	public void setRowoid(Integer rowoid) {
		this.rowoid = rowoid;
	}
	/**
	 * 获取：报表的行标识
	 */
	public Integer getRowoid() {
		return rowoid;
	}
	/**
	 * 设置：选择的列名称
	 */
	public void setColfieldname(String colfieldname) {
		this.colfieldname = colfieldname;
	}
	/**
	 * 获取：选择的列名称
	 */
	public String getColfieldname() {
		return colfieldname;
	}
	/**
	 * 设置：组合后的列标题
	 */
	public void setColname(String colname) {
		this.colname = colname;
	}
	/**
	 * 获取：组合后的列标题
	 */
	public String getColname() {
		return colname;
	}
	/**
	 * 设置：列别名
	 */
	public void setColaliasname(String colaliasname) {
		this.colaliasname = colaliasname;
	}
	/**
	 * 获取：列别名
	 */
	public String getColaliasname() {
		return colaliasname;
	}
	/**
	 * 设置：列显示顺序
	 */
	public void setColorder(Integer colorder) {
		this.colorder = colorder;
	}
	/**
	 * 获取：列显示顺序
	 */
	public Integer getColorder() {
		return colorder;
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
