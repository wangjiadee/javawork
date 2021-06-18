package ralph.devops.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 80288284
 */
@Configuration
@MapperScan({"ralph.devops.dao"})
public class MyBatisConfig {
}
