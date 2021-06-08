package ralph.devops.service.impl;

import org.springframework.stereotype.Service;
import ralph.devops.dao.PaymentDao;
import ralph.devops.entities.Payment;
import ralph.devops.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author ralph
 * @create 2021-06-08 22:11
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
