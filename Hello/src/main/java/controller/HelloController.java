package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.RequestWrapper;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/8 8:56
 */
@Controller
public class HelloController {

    // @RequestMapping注解：处`理请求和控制器方法之间的映射关系`
    // @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
    // localhost:8080/springMVC/
    @RequestMapping(value = "/")
    public String index(){
        // 返回视图名称，交给视图解析器，有前缀，有后缀，正好差一个名称
        return "index";
    }

    // return里的内容和html文件相同，注解里的value值和href里的值相同
    // http://localhost:8080/springMVC/target 这个是浏览器端显示的请求地址，而服务器端的真实文件是mytarget.html
    @RequestMapping(value = {"/target","/test"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"username", "password!=123456"})
    public String toTarget(){
        return "mytarget";
    }

    @GetMapping(value = "/target")
    public String get(){
        return "mytarget";
    }

//    Completed 405 METHOD_NOT_ALLOWED，请求方法不匹配，默认使用get
    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

//    ？：表示任意的单个字符
//    @RequestMapping(value = "/a?a/testAnt")
//    @RequestMapping(value = "/a*a/testAnt")
    @RequestMapping(value = "/**/testAnt")
    public String testAnt(){
        return "success";
    }

    // 路径中的占位符
    @RequestMapping("/testPath/{id}/{username}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username){
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }
}
