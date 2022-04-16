package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ViewController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/12 10:19
 */
@Controller
public class ViewController {

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
//        http://localhost:8080/SpringMVC/testForward
        return "forward:/testThymeleaf";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
//        http://localhost:8080/SpringMVC/testThymeleaf
        return "redirect:/testThymeleaf";
    }
}
