package com.hkd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hkd.mapper.UserMapper;
import com.hkd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    //用户登录
    @RequestMapping("/user/login")
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
//        userQueryWrapper.select("username","password");
        userQueryWrapper.eq("username",username).eq("password",password);
//        List<User> user = userMapper.selectList(userQueryWrapper);
        User user = userMapper.selectOne(userQueryWrapper);

        if(user != null){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
//        //登录判断
//        if (StringUtils.hasText(username) && "123456".equals(password)){
//            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
//        }else {
//            //登录失败
//            model.addAttribute("msg","用户名或者密码错误");
//            return "index";
//        }

    }

    //管理员登录
    @RequestMapping("/toAdminLogin")
    public String AdminLogin(){
        return "login";
    }

    //退出
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        //清除session数据
        session.invalidate();
        return "index";
    }

//    //Security控制端
//    @RequestMapping(value = "/login/{status}",method = RequestMethod.GET)
//    public String login(@PathVariable String status) {
//        System.out.println(status);
//        if("auth".equals(status)){
//            return "没有登录";
//        }
//        if("fail".equals(status)){
//            return "登录失败";
//        }
//        if("success".equals(status)){
//            return "登录成功";
//        }
//        if("logout".equals(status)){
//            return "注销成功";
//        }
//        return "";
//    }
}
