package com.specular.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author jzx
 * @date 2019/03/01 17:19
 * @Description:
 */
@ConfigurationProperties(prefix = "app.config")
@Data
@Configuration
public class AppConfig {
    String name;
}
