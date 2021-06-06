package ralph.ci.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ralph.ci.springboot.bean.User;

import javax.servlet.http.HttpSession;

/**
 * @author ralph
 * @create 2021-06-04 20:33
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * @Description  用于测试druid
     * @return
     */
    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        return aLong.toString();
    }


    /**
     * @Description come to login html
     * @return login html
     */
    @GetMapping(value={"/","/login"})
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        String passWord = "123123";
        if(user.getUserName() != null && passWord.equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","老铁,帐号密码错误");
            return "login";
        }

    }

    /**
     * @Description  come to main.html
     * @return new html
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        log.info("[Iog:] 当前方法是{}","mainPage()");
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请重新登录!");
//            return "login";
//        }
        return "main";

    }

}
