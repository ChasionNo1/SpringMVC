package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/8 20:55
 */
@Controller
public class TestController {

    @RequestMapping(value = "/param")
    public String param(){
        return "test_param";
    }
}
