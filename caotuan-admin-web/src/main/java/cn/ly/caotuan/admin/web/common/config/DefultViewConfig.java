package cn.ly.caotuan.admin.web.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springboot默认页面
 * 
 * @ClassName: DefultView
 * @Description:
 * @Author liuyi
 * @Date: 2018年7月14日下午4:05:51
 */

@Configuration
public class DefultViewConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/welcome.html");
		// setOrder可以设置ViewController的优先级，强烈建议此处设置为最高，这样即使其他Controller中存在一样的映射（即/)，则仍会优先【步骤2】中ViewController
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}
}
