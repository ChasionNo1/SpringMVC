package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName ScopeController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/11 20:16
 */
@Controller
public class ScopeController {

    // 使用servletAPI向request域对象共享数据
    @RequestMapping("testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        // 首页根据注解找到这个前端控制器方法，然后方法里设置了request域对象的共享数据
        // 当跳转到success页面时，就可以访问到了
        request.setAttribute("testRequestScope", "hello, servlet api");
        return "success";
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        // 处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope", "hello model and view");
        // 设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "hello model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope", "hello map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "hello, model map");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        // 整个工程范围，是在服务器启动时创建的，整个工程都是这一个
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }

}
