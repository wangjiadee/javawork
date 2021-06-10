package ralph.devops.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ralph
 * @create 2021-06-08 22:44
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * @LoadBalanced 让RestTemplate拥有负载均衡的能力
     * @return
     */
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
