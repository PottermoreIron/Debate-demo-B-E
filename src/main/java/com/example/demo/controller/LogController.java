package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.LogService;
import org.apache.catalina.Session;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Login")
public class LogController extends BaseController{
    @Resource
    private LogService logService;
    @Resource
    private UserMapper userDao;
    //注册  传参：名字String  密码String  队伍Integer  学级Integer  是否队长boolean  无返回  需要告知用户账号
    @RequestMapping("/Reg")
    @ResponseBody
    public User Reg(@RequestParam("name") String name, @RequestParam ("password") String password, @RequestParam ("team") Integer team,@RequestParam ("grade") Integer grade,@RequestParam ("captain") boolean captain){
        User user1=new User(name,userDao.queryUserList().get(userDao.queryUserList().size()-1).getUser_id()+1,password,null,team,grade,captain);
        logService.reg(user1);
        return user1;
    }

    //登录  输入账号Integer密码String   返回“/Blog”进入首页
    @ResponseBody
    @RequestMapping("/Log")
    public User Log(@RequestParam("uid") Integer uid,@RequestParam("password") String password){
        if (logService.log(uid,password))
        {
            System.out.println("登陆成功");
            System.out.println(userDao);
            setUser(userDao.queryByUserId(uid));
            System.out.println(("欢迎你"+getUser().getUser_name()));
            return userDao.queryByUserId(uid);
        }
        else
            System.out.println("登陆失败");
        return null;
    }
}
