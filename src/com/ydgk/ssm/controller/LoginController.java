package com.ydgk.ssm.controller;

import com.ydgk.ssm.entities.Admin;
import com.ydgk.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author asus
 * @create 2020-02-15 20:34
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminService adminService;

    //用户登录
    @RequestMapping("/loginIn")
    public String loginIn(@RequestParam("loginname") String loginName,
                          @RequestParam("loginpwd") String loginpwd,
                          @RequestParam("roleId") String roleId,
                          @RequestParam("code") String code,
                          @RequestParam( value = "remember",required = false) String remember,
                          HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("code");
        //比较输入的验证码和session中的验证码是否相同，equalsIgnoreCase:不区分大小写的比较
        if (code.equalsIgnoreCase(checkCode)) {

            Admin admin = adminService.queryByNameAndPwd(loginName, loginpwd, roleId);
            if (admin != null) {
                //判断是否勾选上记住密码
                if ("remember-me".equals(remember)) {
                    Cookie usernameCookie = new Cookie("username", URLEncoder.encode(admin.getUsername(), "utf-8"));
                    //账号设置记住7天时间

                    usernameCookie.setMaxAge(60 * 60 * 24 * 7);

                    Cookie userpwdCookie = new Cookie("userpwd", admin.getUserpwd());
                    //密码设置记住3天时间
                    userpwdCookie.setMaxAge(60 * 60 * 24 * 3);

                    //角色设置
                    Cookie ridCookie = new Cookie("rid", admin.getRid().toString());
                    ridCookie.setMaxAge(60 * 60 * 24 * 7);

                    //存入response中
                    response.addCookie(usernameCookie);
                    response.addCookie(userpwdCookie);
                    response.addCookie(ridCookie);
                } else {
                    //如果没有勾选上记住密码，删除coolies值
                    Cookie[] cookies = request.getCookies();
                    for (int i = 0; i < cookies.length; i++) {
                        if ("username".equals(cookies[i].getName())) {
                            cookies[i].setMaxAge(0);
                        }
                        if ("userpwd".equals(cookies[i].getName())) {
                            cookies[i].setMaxAge(0);
                        }
                        if ("rid".equals(cookies[i].getName())) {
                            cookies[i].setMaxAge(0);
                        }
                    }
                }

                // 如果登录成功，跳转到后台主页
                // 1.将管理员对象保存在session
                session.setAttribute("admin", admin);
                if (roleId.equals("1")) {
                    //跳转到学生页面
                    return "student/student";
                } else if (roleId.equals("2")) {
                    //跳转到教师页面
                    return "teacher/teacher";

                } else {
                    //跳转到教务处管理员页面
                    return "admin/admin";
                }


            } else {
                // 登录失败，跳转到登录页面
                // 1.将错误信息存到request中
                request.setAttribute("errorMsg", "账号不存在！");
                // 2.转发到登录页面
                return "main/login";

            }

        } else {
            // 验证码错误，跳转到登录页面
            // 1.将错误信息存到request中
            request.setAttribute("errorMsg", "验证码错误!");
            // 2.转发到登录页面
            return "main/login";

        }

    }

    //去到注册用户页面
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "main/addUser";
    }

    //注册用户
    @RequestMapping("/addUser")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("userpwd") String userpwd,
                          @RequestParam("roleId") String roleId,
                          @RequestParam("problem") String problem,
                          @RequestParam("answer") String answer,
                          Map<String,Object> map){
        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setUserpwd(userpwd);
        admin.setRid(Integer.valueOf(roleId));
        admin.setProblem(problem);
        admin.setAnswer(answer);

        int i=adminService.addUser(admin);

        if (i>0){
            map.put("info","注册成功！");
            return "success/addSuccess";
        }else {
            map.put("info","注册失败！");
           return "success/addSuccess";
        }
    }

//忘记密码，查询密保问题
    @RequestMapping("/queryQuestion")
    public String queryQuestion(@RequestParam("username")String username,
                                Map<String,Object> map){

        Admin admin = adminService.getQuestionByUsername(username);
        map.put("admin",admin);

        if (admin != null) {
            return "main/forget2";
        } else {
            return "error/error3";
        }
    }

    //回答密保问题toUpdateAdminInfo
    @RequestMapping("toUpdateAdminInfo")
    public String toUpdateAdminInfo(@RequestParam("username") String username,
                                    @RequestParam("answer") String answer,
                                    Map<String,Object> map) {
        Admin admin = adminService.queryAdminByAnswer(username, answer);

        map.put("admin", admin);
        map.put("username",username);
        if (admin != null) {
            return "main/updateAdminPwd";
        } else {
            return "error/error2";

        }
    }

    //修改密保问题和密码updateAdminInfo
    @RequestMapping("updateAdminInfo")
    public String updateAdminInfo(@RequestParam("userpwd") String userpwd,
                                  @RequestParam("username") String username,
                                  @RequestParam("rid") String rid,
                                  @RequestParam("userId") String userId,
                                  @RequestParam("problem") String problem,
                                  @RequestParam("answer") String answer,
                                  Map<String,Object> map){

        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setRid(Integer.valueOf(rid));
        admin.setUserpwd(userpwd);
        admin.setProblem(problem);
        admin.setAnswer(answer);
        admin.setUserid(Integer.valueOf(userId));
        int i = adminService.updateById(admin);

        if (i > 0) {
            map.put("info", "信息修改成功！");
            return "success/addSuccess";
        }
        return "";
    }

}

