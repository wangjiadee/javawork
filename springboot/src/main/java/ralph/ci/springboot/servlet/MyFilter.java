package ralph.ci.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ralph
 * @create 2021-06-06 14:18
 * @Description  一个* 是servlet写法 两个* 是springboot写法
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("[log:] MyFilter 初始化init方法");
    }

    @Override
    public void destroy() {
        log.info("[log:] MyFilter 销毁destroy方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("[log:] MyFilter过滤doFilter方法--->开始工作了");
        chain.doFilter(request,response);
    }
}
