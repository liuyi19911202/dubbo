package cn.ly.test.caotuan.dbdata;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring-boot 启动入口
 *
 * @author liuyi
 */
@EnableScheduling
@ServletComponentScan
@SpringBootApplication
public class TestDBCreateApplication {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDBCreateApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(TestDBCreateApplication.class);
        application.setRegisterShutdownHook(false);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        LOGGER.info("Caotuan Test CreateDB Start!");
    }
}
