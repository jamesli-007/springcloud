package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: gfk
 * @create: 2022/11/18
 * @Description:
 * @FileName: MySelfRule
 * @History:
 * @自定义内容：
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule()
    {
        return new RandomRule();//定义为随机
    }
}

