package com.specular.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author jzx
 * @date 2019/03/01 17:19
 * @Description:
 */
@ConfigurationProperties(prefix = "app.api")
@Data
@Configuration
public class ApiConfig {
    String version;
    String minVersion;
}
