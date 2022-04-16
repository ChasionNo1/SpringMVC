package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/11 19:54
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/test_view")
    public String test_view(){
        return "test_view";
    }

    @RequestMapping("/test_rest")
    public String test_rest(){
        return "test_rest";
    }
}
