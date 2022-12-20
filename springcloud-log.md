### RestTemplate 简单使用

上面的方法我们大致可以分为三组：

- getForObject --- optionsForAllow 分为一组，这类方法是常规的 Rest API（GET、POST、DELETE 等）方法调用；

- exchange：接收一个 `RequestEntity` 参数，可以自己设置 HTTP method，URL，headers 和 body，返回 ResponseEntity；

- execute：通过 callback 接口，可以对请求和返回做更加全面的自定义控制。

  ribbon 客户端 负载均衡、

  集中式的LB(load balance) nginx

  本地式的LB ribbon

  ribbon 工作步骤 （负载均衡 + resttemplate）

  1选择EurekaServer，选择一个同区域内负载较少的server

  2根据用户指定的策略（轮询，随机）找到一个地址

## 11.18

ribbon 随机 注意不能有包扫描注释,@SpringBootApplication 自带@ComponentScan所以需要重建一个包设置随机分配原则的实体类  并在消费者的加上注解表示引用刚写的类



## 轮询算法 第几次数 % 机器数 求余

## CAS 自旋锁



## 11.26

feign的配置2个必须的注解

![image-20221126102948574](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221126102948574.png)





直接在yml文件中配置![image-20221126110058870](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221126110058870.png)

feign的日志

1 config配置类的编写

![image-20221129092450489](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221129092450489.png)

2 yml文件

![image-20221129092419185](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221129092419185.png)

  断路器   **降级 熔断 监控**

![image-20221129092618813](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221129092618813.png)

服务降级：程序异常， 超时，线程池满了，服务熔断触发

服务熔断：达到服务最大访问后，调用服务降级

服务限流：秒杀高并发，排队

```
TimeUnit.SECONDS.sleep(3) 耗时3秒钟
```

hystrix

![image-20221129113045931](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221129113045931.png)



## 12.1

方法上加上超时，出错回调注解@HystrixCommand

主启动类上加上@EnableCircuitBreaker

热部署对@HystrixCommand等相关注解可能不会生效

![image-20221201153607888](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221201153607888.png)

feign 接口 统一的定义fallback 进行统一的调度

在接口上添加  fallback="xxx,class"

服务熔断 在开闭之间引入了第三中状态

<img src="C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221201164518711.png" alt="image-20221201164518711" style="zoom: 67%;" />

hutool工具包

IdUtil.simpleUUID(); == UUID.randomUUID().toString()

## 12.2

熔断 ：超时 宕机 出错

hystrix 监控程序

9001监控8001

1  依赖![image-20221202150223999](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202150223999.png)

2  8001主启动添加代码

![image-20221202150826785](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202150826785.png)

3  网页配置 添加地址

![image-20221202151726920](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202151726920.png)

**gateway**

![image-20221202152412261](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202152412261.png)

![image-20221202152449259](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202152449259.png)

3大核心概念

路由（地址）

断言（判断）

过滤（过滤器）

gateway的工作流程



![image-20221202153314221](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202153314221.png)

![image-20221202153254940](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202153254940.png)

在yml文件中配置需要加网关的地址

![image-20221202164245544](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221202164245544.png)

## 12.6

网关的配置 2中方式

1yml 

2代码注入RouteLocator 的Bean

gateway配置动态路由yml文件中添加注册中心地址

predicate断言

时间转换时区

```
ZonedDateTime zbj = ZonedDateTime.now();
System.out.println(zbj);
```

2022-12-06T11:27:27.792+08:00[Asia/Shanghai]

## 12.7

分布式配置中心

一处修改，处处生效

![image-20221207092604049](C:\Users\32334\AppData\Roaming\Typora\typora-user-images\image-20221207092604049.png)

## 12.16
