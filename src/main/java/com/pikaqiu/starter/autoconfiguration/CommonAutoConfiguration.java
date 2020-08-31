package com.pikaqiu.starter.autoconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(CommonProperties.class)
@ConditionalOnClass(CommonPropertyService.class)
@ConditionalOnProperty(prefix = "common.property", value = {"name","desc"}, matchIfMissing = true)
public class CommonAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(CommonAutoConfiguration.class);

    @Bean
    public CommonPropertyService getCommonProperty(CommonProperties commonProperties) {
        logger.info("Common Starter is Success Injection...");
        CommonPropertyService commonService = new CommonPropertyService();
        commonService.setOutInfo(commonProperties.toString());
        return commonService;
    }

}
