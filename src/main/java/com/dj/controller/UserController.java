package com.dj.controller;

import com.dj.pojo.User;
import com.dj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //前往登录界面
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    //登录验证
    @RequestMapping("/login")
    public String login(HttpSession session, User user, Model model){
        System.out.println("login得到的user=>"+user);
        String username = user.getUsername();
        User user1 = userService.queryByUserName(username); //数据库得到的用户信息
        if (user1!=null){
            session.setAttribute("userLoginInfo",user.getUsername());
            user.setId(user1.getId());
            if (user.getPassword().equals(user1.getPassword())){
                return "redirect:/book/allBook";
            }else {
                model.addAttribute("loginMsg","密码错误");
            }
        }else {
            model.addAttribute("loginMsg","账号错误");
        }
        return "redirect:/user/goLogin";
    }

    //注销，退出登录
    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        session.removeAttribute("userLoginInfo"); //移除session
        return "redirect:/user/goLogin";
    }
}
