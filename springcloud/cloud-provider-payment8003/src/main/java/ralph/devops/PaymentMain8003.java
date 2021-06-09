package ralph.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ralph
 * @create 2021-06-08 21:58
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class,args);
    }
}


