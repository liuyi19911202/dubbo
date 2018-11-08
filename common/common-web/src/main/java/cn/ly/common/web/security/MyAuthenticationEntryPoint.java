package cn.ly.common.web.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当访问权限验证失败是，根据Restful规范返回401
 * Unauthorized，因此需要设定entry-point-ref，重新指向一个自定义的entrypoint如下：
 *
 * @author liuyi
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		// This is invoked when user tries to access a secured REST resource without
		// supplying any credentials
		// We should just send a 401 Unauthorized response because there is no 'login
		// page' to redirect to
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未授权");
	}
}