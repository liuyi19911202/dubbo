package cn.ly.caotuan.phone.client.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import cn.ly.common.web.config.AbstractWebSecurityConfig;

/**
 * spring-security配置
 *
 * @author liuyi
 */
@Configuration
public class WebSecurityConfig extends AbstractWebSecurityConfig {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略权限校验的访问路径
        web
            .ignoring()
            .antMatchers(
                "/hello",
                "/favicon.ico",
                "/swagger**/**",
                "/*/api-docs",
                "/webjars/**",
                "/*/sms/captcha",
                "/*/user/password",
                "/*/currency/**"
            )
            .antMatchers(HttpMethod.POST, "/*/user")
        ;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/*/auth/token").permitAll();
        super.configure(security);
    }
}
