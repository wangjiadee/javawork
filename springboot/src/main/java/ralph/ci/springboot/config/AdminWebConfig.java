package ralph.ci.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ralph.ci.springboot.interceptor.LoginInterceptor;

/**
 * @author ralph
 * @create 2021-06-05 17:31
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * @Description  将我们自己的拦截器添加到容器中并配置
     * .addPathPatterns("/**") 表示拦截所有的资源(包括静态资源)
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加一个拦截器并配置拦截和放行规则
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
