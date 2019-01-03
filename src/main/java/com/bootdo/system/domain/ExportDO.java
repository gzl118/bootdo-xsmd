package com.bootdo.system.domain;

import java.io.Serializable;

public class ExportDO implements Serializable {
	private String raq;
	private String rdate;
	private String rfoid;
	private String roid;
	private String rdepart;

	public String getRaq() {
		return raq;
	}

	public void setRaq(String raq) {
		this.raq = raq;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getRfoid() {
		return rfoid;
	}

	public void setRfoid(String rfoid) {
		this.rfoid = rfoid;
	}

	public String getRoid() {
		return roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public String getRdepart() {
		return rdepart;
	}

	public void setRdepart(String rdepart) {
		this.rdepart = rdepart;
	}

}
