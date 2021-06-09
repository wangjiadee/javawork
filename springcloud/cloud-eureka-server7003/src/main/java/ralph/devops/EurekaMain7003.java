package ralph.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description :@EnableEurekaServer 表示这个是eureka 的service
 * @author 80288284
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7003.class,args);
    }
}
