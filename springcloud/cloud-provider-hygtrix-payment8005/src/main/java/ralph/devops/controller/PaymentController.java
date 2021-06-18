package ralph.devops.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ralph.devops.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author ralph
 * @create 2021-06-10 21:26
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentInfoOK(id);
        log.info("*****result: "+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("*****result: "+result);
        return result;
    }


    /**
     * 服务熔断
     */

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

}
