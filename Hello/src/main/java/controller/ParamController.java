package controller;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @ClassName ParamController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/8 20:51
 */
@Controller
public class ParamController {

//    将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
    @RequestMapping(value = "/testServletAPI")
    public String testServletAPI(HttpServletRequest req){
        // 第一次在响应报文中，后面将在请求头中
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

//    在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，在DispatcherServlet中就会将请求参数赋值给相应的形参
    @RequestMapping(value = "/testParam")
    public String testParam(@RequestParam(value = "user_name", required = false, defaultValue = "hehe") String username, String password, String[] hobby,
    @RequestHeader(value = "host", required = false, defaultValue = "hehe") String host,
    @CookieValue(value= "JSESSIONID", required = true, defaultValue = "") String JSESSIONID){
        // 多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或者字符串数组接收
//        username:20201218004,password:123456,hobby:a,b,c
//        数组形式
//        username:20201218004,password:123456,hobby:[a, b, c]
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));
        System.out.println(host);
        System.out.println("JSESSIONID:" + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testpojo")
    // 可以在方法形参里接收form表单里的键值对，可以实体类接收
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
