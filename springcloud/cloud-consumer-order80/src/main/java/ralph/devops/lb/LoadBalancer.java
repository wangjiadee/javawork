package ralph.devops.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 80288284
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
