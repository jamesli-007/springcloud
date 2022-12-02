package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: gfk
 * @create: 2022/11/26
 * @Description:
 * @FileName: PaymentService
 * @History:
 * @自定义内容：
 */
@Component

@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //找到对应服务下面的方法（ERUEKA上面的名字）
public interface PaymentFeignService {
    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}

