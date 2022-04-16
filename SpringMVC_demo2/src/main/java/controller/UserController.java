package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/12 16:23
 */
@Controller
public class UserController {

    /**
     * 使用RESTFul模拟用户资源的增删改查
     * /user        GET     查询所有用户信息
     * /user/1      GET     查询用户id查询用户信息
     * /user        POST    添加用户信息
     * /user/1      DELETE  删除用户信息
     * /user        PUT     修改用户信息
     *
     * */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getById(){
        System.out.println("查询指定id用户信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(String username, String password){
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password){
        System.out.println("修改");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }


}
