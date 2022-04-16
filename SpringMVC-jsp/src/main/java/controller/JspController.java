package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName JspController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/12 15:32
 */
@Controller
public class JspController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    // 这里只有两种视图，转发视图和重定向视图
    // 当没有前缀或者以forward:/为前缀时，是转发视图

}
