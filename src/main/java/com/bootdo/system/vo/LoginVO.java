package com.bootdo.system.vo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="LoginVO",description="用户登录")
public class LoginVO implements Serializable{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="用户登录名")
	 String username;
	@ApiModelProperty(value="用户密码")
	 String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
