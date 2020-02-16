package com.ydgk.ssm.controller;

import com.ydgk.ssm.entities.Admin;
import com.ydgk.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author asus
 * @create 2020-02-16 10:48
 */
@Controller
public class CommonController {
    @Autowired
    private AdminService adminService;

    //进入到修改自己密码页面
    @RequestMapping("/toUpdateMe")
    public String toUpdateMe(@RequestParam("userId") Integer userId, Map<String, Object> map) {
        Admin admin = adminService.getAdminById(userId);
        map.put("admin", admin);

        return "main/updateMe";
    }

    //修改当前用户密码
    @RequestMapping("/updateMe")
    public void updateMe(@RequestParam("userId") Integer userId, @RequestParam("newpass") Integer newpass,
                         HttpServletResponse response) throws IOException {

        Admin admin = adminService.getAdminById(userId);
        admin.setUserpwd(newpass.toString());
        adminService.updateById(admin);

        //如果直接跳出到登录页面，则会出现只有在内联框架里面跳转
        //从而需要通过父框架跳转
        PrintWriter out=response.getWriter();
        out.write("<script>parent.location.href='login.jsp';</script>");
        out.flush();
        out.close();

    }
}
