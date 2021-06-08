package ralph.devops.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ralph.devops.entities.Payment;

/**
 * @author ralph
 * @create 2021-06-08 22:08
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}