老的Hystrix 需要自己手动搭建监控平台，并且没有一套web界面可以给我们进行更多的细粒度化的配置（熔断、降级等）

官网：https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D

Sentinel 其实就是很早之前的Hystrix





###### pom.xml 配合使用案例

```xml
        <!--SpringCloud ailibaba nacos -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <!--SpringCloud ailibaba sentinel-datasource-nacos 后续做持久化用到-->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-nacos</artifactId>
        </dependency>
        <!--SpringCloud ailibaba sentinel -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
```



Sentinel 使用懒加载机制，需要使用or访问一次服务 才会被加载到sentinel中

#### 流控规则

关联留空模式 A访问和B访问想关联 如果B 达到了阈值 那么A的访问将被限制

```
如 支付访问量巨大 那么就暂时关闭访问下单的访问
```

###### 预热

默认coldFactor为3，即请求QPS 从 threshold / 3开始，经预热时长逐渐升至设定的QPS阈值

###### 排队等待





![image-20210617104029452](C:\Users\80288284\Desktop\Workbench\java_springcloud\mind\img\image-20210617104029452.png)



@SentinelResource主管配置出错，运行出错该走异常走异常







![image-20210617142505039](C:\Users\80288284\Desktop\Workbench\java_springcloud\mind\img\image-20210617142505039.png)

- **Load**（仅对 Linux/Unix-like 机器生效）：当系统 load1 超过阈值，且系统当前的并发线程数超过系统容量时才会触发系统保护。系统容量由系统的 `maxQps * minRt` 计算得出。设定参考值一般是 `CPU cores * 2.5`。
- **CPU usage**（1.5.0+ 版本）：当系统 CPU 使用率超过阈值即触发系统保护（取值范围 0.0-1.0）。
- **RT**：当单台机器上所有入口流量的平均 RT 达到阈值即触发系统保护，单位是毫秒。
- **线程数**：当单台机器上所有入口流量的并发线程数达到阈值即触发系统保护。
- **入口 QPS**：当单台机器上所有入口流量的 QPS 达到阈值即触发系统保护。



#### 按资源名称限流+后续处理

