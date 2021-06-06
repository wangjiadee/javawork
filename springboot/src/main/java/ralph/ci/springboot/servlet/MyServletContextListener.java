package ralph.ci.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ralph
 * @create 2021-06-06 14:24
 */
@Slf4j
//@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("[log:] MyServletContextListener监听项目初始化contextInitialized方法");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("[log:] MyServletContextListener监听项目销毁contextDestroyed方法");
    }
}
