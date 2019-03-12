package com.bootdo.system.publish.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.R;
import com.bootdo.system.vo.LoginVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish/login")
public class PLoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Log("登录")
	@PostMapping("/login")
	@ApiOperation(value="系统登录", notes="统一登录接口")
	@ApiResponses({
		@ApiResponse( response = R.class, code = 200, message = "返回结构:R.class")
	})
	R Login(@RequestBody LoginVO login) {

		login.setPassword(MD5Utils.encrypt(login.getUsername(), login.getPassword()));
		UsernamePasswordToken token = new UsernamePasswordToken(login.getUsername(), login.getPassword());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok("用户登录成功");
		} catch (AuthenticationException e) {
			return R.error("用户或密码错误");
		}
	}

}
