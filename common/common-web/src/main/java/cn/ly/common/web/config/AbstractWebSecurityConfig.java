package cn.ly.common.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsUtils;

import cn.ly.common.web.filter.CorsFilter;
import cn.ly.common.web.security.AuthenticationTokenFilter;
import cn.ly.common.web.security.MyAuthenticationEntryPoint;

/**
 * spring-security配置
 *
 * @author liuyi
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class AbstractWebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 用户信息服务
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Password encoder password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(8);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Authentication token filter bean authentication token filter.
	 *
	 * @return the authentication token filter
	 */
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() {
		return new AuthenticationTokenFilter();
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security
				// 禁用 csrf
				.csrf().disable().exceptionHandling().
				// 添加未授权处理
				authenticationEntryPoint(new MyAuthenticationEntryPoint()).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				// 允许对于网站静态资源的无授权访问
				.antMatchers(HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js")
				.permitAll()
				// 所有 / 的所有请求 都放行,对preflight放行
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				// 所有请求需要身份认证
				.anyRequest().authenticated();

		// Custom JWT based security filter
		// 验证是否有登录信息
		security.addFilterAfter(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

		// 验证跨域请求的heard
		security.addFilterBefore(new CorsFilter(), CsrfFilter.class);

		// 禁用缓存
		security.headers().cacheControl();

	}
}
