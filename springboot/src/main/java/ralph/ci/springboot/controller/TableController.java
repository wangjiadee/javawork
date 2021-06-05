package ralph.ci.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ralph.ci.springboot.bean.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author ralph
 * @create 2021-06-05 14:44
 */
@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basicTable(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTable(Model model){
        List<User> users = Arrays.asList(new User("zhangsan", "123123"),
                new User("lisi", "123123"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editableTable(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricingTable(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){
        return "table/responsive_table";
    }
}
