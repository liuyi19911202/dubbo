package cn.ly.caotuan.admin.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ly.caotuan.admin.web.WebAdminApplication;
import cn.ly.caotuan.admin.web.common.controller.BaseController;
import cn.ly.caotuan.admin.web.security.utils.TokenUtil;
import cn.ly.common.web.security.AuthenticationTokenFilter;
import cn.ly.system.api.entity.SysUser;

/**
 * 认证控制器
 * @ClassName: AuthenticationController
 * @author liuyi
 * @date 2018年8月13日
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController extends BaseController {
	/**
	 * 权限管理
	 */
	@Autowired
	private AuthenticationManager authenticationManager;
	/**
	 * 用户信息服务
	 */
	@Autowired
	private UserDetailsService userDetailsService;
	/**
	 * Token工具
	 */
	@Autowired
	private TokenUtil jwtTokenUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(WebAdminApplication.class);

	/**
	 * 创建身份令牌，并用此身份令牌登录
	 *
	 * @param sysUser
	 *            the sys user
	 * @return the bearer auth token
	 */
	@PostMapping(value = "/token")
	public Map<String, Object> createAuthenticationToken(@RequestBody SysUser sysUser) {
		LOGGER.info("请求/auth/token方法,当前接受的参数sysUser:{}",sysUser);
		// ======================验证过程authentication====================
		// 1.用户名和密码被获取到，并放入一个 UsernamePasswordAuthenticationToken 实例中
		// 2.这个token被传递到一个 AuthenticationManager 实例中进行验证
		// 3.在成功验证后， AuthenticationManager返回一个所有字段都被赋值的 Authentication 对象实例
		// AuthenticationManager就是认证管理器
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(sysUser.getLoginName(), sysUser.getPassword()));
		// ======================授权authorization=========================
		// 4.创建安全上下文，通过返回的验证对象进行传递
		SecurityContextHolder.getContext().setAuthentication(authentication);

		final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		final String token = jwtTokenUtil.generateToken(userDetails);

		// Return the token
		Map<String, Object> tokenMap = new HashMap<>();
		tokenMap.put("access_token", token);
		tokenMap.put("expires_in", jwtTokenUtil.getExpiration());
		tokenMap.put("token_type", TokenUtil.TOKEN_TYPE_BEARER);
		return tokenMap;
	}

	/**
	 * 刷新并获取身份验证令牌承载身份验证令牌
	 *
	 * @param request
	 *            the request
	 * @return the bearer auth token
	 */
	@GetMapping(value = "/refresh")
	public Map<String, Object> refreshAndGetAuthenticationToken(HttpServletRequest request) {

		String tokenHeader = request.getHeader(AuthenticationTokenFilter.TOKEN_HEADER);
		String token = tokenHeader.split(" ")[1];

		String username = jwtTokenUtil.getUsernameFromToken(token);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		final String refreshedToken = jwtTokenUtil.generateToken(userDetails);

		Map<String, Object> tokenMap = new HashMap<>();
		tokenMap.put("access_token", refreshedToken);
		tokenMap.put("expires_in", jwtTokenUtil.getExpiration());
		tokenMap.put("token_type", TokenUtil.TOKEN_TYPE_BEARER);
		return tokenMap;
	}

	/**
	 * 删除认证令牌
	 *
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@DeleteMapping(value = "/token")
	public ResponseEntity deleteAuthenticationToken(HttpServletRequest request) {

		String tokenHeader = request.getHeader(AuthenticationTokenFilter.TOKEN_HEADER);
		String token = tokenHeader.split(" ")[1];

		jwtTokenUtil.removeToken(token);

		return new ResponseEntity(HttpStatus.OK);
	}

}
