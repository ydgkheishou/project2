package com.ydgk.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydgk.ssm.entities.Admin;
import com.ydgk.ssm.entities.Course;
import com.ydgk.ssm.entities.Grade;
import com.ydgk.ssm.entities.Infomation;
import com.ydgk.ssm.service.AdminService;
import com.ydgk.ssm.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author asus
 * @create 2020-02-13 15:25
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admins")
    public String toAdmins() {
        return "admin/admin";
    }

    //进入到角色管理界面
    @RequestMapping("/toAccountList")
    public String toAccountList(Map<String, Object> map,
                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum
            , @RequestParam(value = "role", required = false, defaultValue = "1") Integer role,
                                @RequestParam(value = "name", required = false, defaultValue = "%%") String name) {
        PageHelper.startPage(pageNum, 2);

        List<Admin> studentAndTeacherInfo = adminService.getStudentAndTeacherInfo(role, name);

        //roleid用于角色查询，name用于回显
        map.put("roleId", role);
        if (!name.equals("%%")) {
            map.put("name", name);
        }

        PageInfo<Admin> adminPageInfo = new PageInfo<>(studentAndTeacherInfo, 3);
        map.put("adminPageInfo", adminPageInfo);
        return "admin/accountList";
    }

    /*//删除角色
    @RequestMapping("/deleteRoleById")
    public String deleteRoleById(Map<String,Object> map,
                              @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum
                              ,@RequestParam(value="role",required = false,defaultValue = "1") Integer role,
                              @RequestParam(value = "userId") Integer userId){
        PageHelper.startPage(pageNum,2);
        int i=0;
        //roleid用于角色查询，name用于回显
        map.put("roleId",role);
         i=adminService.deleteById(userId);
         String name="%%";
        List<Admin> studentAndTeacherInfo = adminService.getStudentAndTeacherInfo(role,name);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(studentAndTeacherInfo, 3);
        map.put("adminPageInfo",adminPageInfo);
        return "admin/accountList";
    }*/

    //删除用户
    @ResponseBody
    @RequestMapping("/deleteRoleById")
    public Boolean deleteCost(@RequestParam("userId") Integer userId) {
        int i = adminService.deleteById(userId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    //初始化密码
    @ResponseBody
    @RequestMapping("/rePassWorld")
    public Boolean rePassWorld(@RequestParam("userId") Integer userId) {
        int i = adminService.updatePasswd(userId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    //进入到修改用户密码页面
    @RequestMapping("/toUpdate")
    public String toUpdate(@RequestParam("userId") Integer userId, Map<String, Object> map,
                           @RequestParam(value = "pageNum",required =false,defaultValue = "1") Integer pageNum) {
        Admin admin = adminService.getAdminById(userId);
        map.put("admin", admin);
        map.put("pageNum", pageNum);

        return "admin/update";
    }

    //修改用户密码
    @RequestMapping("/update")
    public String update(@RequestParam("userId") Integer userId, @RequestParam("userPassword") Integer userPassword,
                         @RequestParam("pageNum") Integer pageNum) {

        Admin admin = adminService.getAdminById(userId);
        admin.setUserpwd(userPassword.toString());
        int i=adminService.updateById(admin);
        return "redirect:/admin/toAccountList?pageNum=" + pageNum;
    }

    //进入到发布公告页面toAddInfomation
    @RequestMapping("/toAddInfomation")
    public String toAddInfomation(Map<String, Object> map) {

        List<Infomation> infomation = infoService.getInfomation();
        map.put("infomationList", infomation);
        return "admin/addInfomation";
    }

    //发布公告addInfomation
    @RequestMapping("/addInfomation")
    public String addInfomation(@RequestParam("text") String text) {

        infoService.addInfo(text);
        return "redirect:/admin/toAddInfomation";
    }

    //删除公告信息

    @RequestMapping("/deleteInfomation")
    public String deleteInfomation(@RequestParam("nid") Integer nid, Map<String, Object> map) {
        infoService.deleteInfo(nid);

        return "redirect:/admin/toAddInfomation";
    }

    //进入到课程注册页面toAddCourse
    @RequestMapping("/toAddCourse")
    public String toAddCourse(Map<String, Object> map) {
        List<Admin> admins = adminService.getAdminByRoleId();
        map.put("admins", admins);
        return "admin/addCourse";
    }

    //注册课程
    @RequestMapping("/addCourse")
    public String addCourse(Map<String, Object> map, @RequestParam("coursename") String courseName,
                            @RequestParam("courseclass") String courseclass,
                            @RequestParam("tid") Integer tid) {
        Course course = new Course();
        course.setCoursename(courseName);
        course.setCourseclass(courseclass);
        course.setTid(tid);
        int i = adminService.add(course);

        if (i > 0) {
            map.put("info", "课程注册成功！");
            return "success/addCourseSuccess";
        } else {
            map.put("info", "课程注册失败！");
            return "success/addCourseSuccess";
        }

    }

    //学生成绩分页查询queryGradeByPage
    @RequestMapping("/queryGradeByPage")
    public String queryGradeByPage(Map<String, Object> map,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "name", required = false, defaultValue = "%%") String name,
                                   @RequestParam(value = "number", required = false, defaultValue = "0") Integer number) {
        //查询主课程
        List<Course> courses = adminService.getCourses();
        map.put("courses", courses);

        //用于回显
        if (!name.equals("%%")) {
            map.put("name", name);
        }
        if (number != 0) {
            map.put("number", number);
        }


        PageHelper.startPage(pageNum, 2);

        List<Admin> admins = adminService.queryGrade(name, number);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins, 3);
        //查询学生成绩

        map.put("adminPageInfo", adminPageInfo);

        return "admin/gradeList";
    }

    //删除学生成绩
    @RequestMapping("/deleteGrade")
    public String deleteGrade(@RequestParam("gid") Integer gid,
                              @RequestParam("pageNum") Integer pageNum,
                              @RequestParam("userId") Integer userid) {


        //删除分数信息
        adminService.deleteGradeById(gid);
        return "redirect:/admin/queryGradeByPage?pageNum=" + pageNum;
    }

    //进入到上传页面
    @RequestMapping("/toUploadGrade")
    public String toUploadGrade(@RequestParam("userId") Integer userid,
                                @RequestParam("pageNum") Integer pageNum,
                                @RequestParam("username") String username,
                                Map<String, Object> map) {
        //用于后面的加入sid
        map.put("userid", userid);
        //用于上传后跳转回原来的页面
        map.put("pageNum", pageNum);
        map.put("username", username);
        return "admin/uploadGrade";

    }

    //上传学生成绩
    @RequestMapping("/gradeInsert")
    public String gradeInsert(@RequestParam("userId") Integer userid,
                              @RequestParam("number") Integer number,
                              @RequestParam("gradeOne") Integer gradeOne,
                              @RequestParam("gradeTwo") Integer gradeTwo,
                              @RequestParam("gradeThree") Integer gradeThree,
                              Map<String, Object> map
    ) {
        Grade grade = new Grade();
        grade.setGradeOne(gradeOne);
        grade.setGradeTwo(gradeTwo);
        grade.setGradeThree(gradeThree);
        grade.setSid(userid);
        grade.setNumber(number);

        Integer sum = gradeOne + gradeTwo + gradeThree;
        grade.setSum(sum);
        int i = adminService.insertGrade(grade);

        if (i > 0) {
            map.put("info", "上传成功！");
            return "success/uploadGradeSuccess";
        } else {
            map.put("info", "上传失败！");
            return "success/uploadGradeSuccess";
        }

    }

    //进入到成绩修改页面
    @RequestMapping("/toUpdateGrade")
    public String toUpdateGrade(@RequestParam("gid") Integer gid,
                                @RequestParam("pageNum") Integer pageNum,
                                Map<String, Object> map) {


        Admin admin = adminService.toSelectInfo(gid);
        map.put("admin", admin);
        map.put("pageNum", pageNum);
        //查询主课程
        List<Course> courses = adminService.getCourses();
        map.put("courses", courses);


        return "admin/updateGrade";
    }

    //修改学生成绩
    @RequestMapping("/updateGrade")
    public String update(@RequestParam("gid") Integer gid,
                         @RequestParam("pageNum") Integer pageNum,
                         @RequestParam("gradeOne") Integer gradeOne,
                         @RequestParam("gradeTwo") Integer gradeTwo,
                         @RequestParam("gradeThree") Integer gradeThree,
                         Map<String, Object> map) {
        Grade grade = new Grade();
        grade.setGradeOne(gradeOne);
        grade.setGradeTwo(gradeTwo);
        grade.setGradeThree(gradeThree);

        Integer sum = gradeOne + gradeTwo + gradeThree;
        grade.setSum(sum);
        grade.setGid(gid);

        adminService.toUpdateGrade(grade);
        return "redirect:/admin/queryGradeByPage?pageNum=" + pageNum;

    }

}
