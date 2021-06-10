package ralph.devops.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ralph.devops.entities.CommonResult;
import ralph.devops.entities.Payment;

/**
 * @FeignClient(value = "CLOUD-PROVIDER-SERVICE")
 * 接口内的service方法 使用的是那个服务 value写服务的名字
 * @author 80288284
 */
@Configuration
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
