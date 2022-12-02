package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author: gfk
 * @create: 2022/12/1
 * @Description:
 * @FileName: PaymentFeignService
 * @History:
 * @自定义内容：
 *
 */
@Component
public class PaymentFeignService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_TimeOut";
    }
}

