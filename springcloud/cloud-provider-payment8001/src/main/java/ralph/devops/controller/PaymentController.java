package ralph.devops.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ralph.devops.entities.CommonResult;
import ralph.devops.entities.Payment;
import ralph.devops.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author ralph
 * @create 2021-06-08 22:13
 */

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    /**
     * @Description     只传给前端CommonResult，不需要前端了解其他的组件
     * @param payment   实体对象
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功",result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }
}
