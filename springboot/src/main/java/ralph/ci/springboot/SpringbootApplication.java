package ralph.ci.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author ralph
 * @Description @ServletComponentScan(basePackages = "ralph.ci.springboot")
 *              指定源生的Servlet组件都放在那里
 */
@ServletComponentScan(basePackages = "ralph.ci.springboot")
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
