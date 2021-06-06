package ralph.ci.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ralph
 * @create 2021-06-06 13:56
 * @Description  @WebServlet(urlPatterns = "/my") 直接响应 没有经过spring的拦截器
 */

//@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("6666");
    }
}
