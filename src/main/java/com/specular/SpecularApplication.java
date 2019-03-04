package com.specular;

import com.specular.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author jzx
 * @date 2019/02/28 15:33
 * @Description:
 */

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableCaching
public class SpecularApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(SpecularApplication.class, args);
        SpringUtil.setApplicationContext(ctx);
    }
    
}
