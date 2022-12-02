package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * @author: gfk
 * @create: 2022/11/26
 * @Description:
 * @FileName: FeignConfig
 * @History:
 * @自定义内容：
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}

