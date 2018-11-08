package cn.ly.caotuan.admin.web.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonControllerConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ObjectMapper ObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		// 转义字符-异常情况：
		objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		return objectMapper;
	}
}
