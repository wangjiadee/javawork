package ralph.ci.springboot.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Description  @Configuration 需要保证加入到容器里面的是单实例的 不然每次监听都是new 一个新的
 * @author ralph
 * @create 2021-06-06 14:29
 */
@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet,"/my");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
//        {//直接使用myServlet里面的路径
//            return new FilterRegistrationBean(myFilter,myServlet());
//        }
        {
            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
            filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
            return filterRegistrationBean;
        }
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }
}
