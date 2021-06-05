package ralph.ci.springboot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description  登录检查
 * @author ralph
 * @create 2021-06-05 17:25
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * @Description 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //日志输出 获取拦截的请求路径
        String requestUrl = request.getRequestURI();
        log.info("[Iog:] 拦截的请求路径是{}",requestUrl);

        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return true;
        }
        //默认拦截成功 页面是空白的 所以需要重定向到出页页面
//        session.setAttribute("msg","先登录吧,别搞了");
//        response.sendRedirect("/");
        request.setAttribute("msg","先登录吧,别搞了");
        request.getRequestDispatcher("/").forward(request,response);


        return false;
    }

    /**
     * @Description 目标方法执行完成以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[Iog:] postHandleRUN:{}",modelAndView);
    }

    /**
     * @Description  页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("[Iog:] afterCompletionRUN 有异常输出异常:{}",ex);
    }
}
