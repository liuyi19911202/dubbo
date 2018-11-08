package cn.ly.caotuan.admin.web.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import cn.ly.common.web.config.AbstractWebSecurityConfig;

/**
 * spring-security配置
 * 
 * @ClassName: WebSecurityConfig
 * @author liuyi
 * @date 2018年8月13日
 */
@Configuration
public class WebSecurityConfig extends AbstractWebSecurityConfig {

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests()
				// 允许以下请求
				.antMatchers(HttpMethod.POST, "/auth/token").permitAll();
		super.configure(security);
	}
}
