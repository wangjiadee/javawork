package ralph.devops.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOK(Integer id) {
        return "---------> From PaymentHystrixService Fall Back - - !";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "---------> From PaymentHystrixService Fall Back - - !";
    }
}
