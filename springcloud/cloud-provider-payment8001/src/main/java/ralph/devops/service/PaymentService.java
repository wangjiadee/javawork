package ralph.devops.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import ralph.devops.entities.Payment;

/**
 * @author ralph
 * @create 2021-06-08 22:10
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
