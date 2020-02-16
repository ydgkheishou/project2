package com.ydgk.ssm.service;

import com.ydgk.ssm.entities.*;
import com.ydgk.ssm.mappers.AdminMapper;
import com.ydgk.ssm.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author asus
 * @create 2020-02-13 17:37
 */
@Service
public class AdminService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private AdminMapper adminMapper;

    /*只能进行精确查询
    public List<Admin> getStudentAndTeacherInfo(Integer role,String name){
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andRidEqualTo(role);

        criteria.andUsernameLike(name);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        return admins;
    }*/

    //模糊角色查询
    public List<Admin> getStudentAndTeacherInfo(Integer role,String name){
        List<Admin> admins = adminMapper.selectByRoleAndName(role,name);
        return admins;
    }

    //删除角色
    public int deleteById(Integer userId) {
        //Integer id=Integer.valueOf(userId);
        int i = adminMapper.deleteByPrimaryKey(userId);
        return i;
    }

    //初始化密码
    public int updatePasswd(int i) {
        int a=adminMapper.updatePwd(i);
        return a;
    }

    public Admin getAdminById(Integer userId) {
        Admin admin = adminMapper.selectByPrimaryKey(userId);
        return admin;
    }

    public int updateById(Admin admin) {
       int i= adminMapper.updateByPrimaryKey(admin);
       return i;
    }


    public List<Course> getCourses() {

        List<Course> courses = courseMapper.selectCourse();
        return courses;
    }

    public List<Admin> getAdminByRoleId() {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andRidEqualTo(2);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        return admins;
    }

    public int add(Course course) {
        int i = courseMapper.insert(course);
        return i;
    }

    public List<Admin> queryGrade(String name,Integer number) {
        List<Admin> admins=adminMapper.selectGrade(name,number);

        return admins;
    }



    public void deleteGradeById(Integer gid) {
        adminMapper.delete(gid);
    }


    public int insertGrade(Grade grade) {
        int i=adminMapper.toInsert(grade);
        return i;
    }

    public Admin toSelectInfo(Integer gid) {
      Admin admin=  adminMapper.selectInfo(gid);
      return admin;
    }

    public void toUpdateGrade(Grade grade) {
        adminMapper.updateGrade(grade);
    }

    public Admin queryByNameAndPwd(String loginName, String loginpwd, String roleId) {
       Admin admin= adminMapper.queryInfo(loginName, loginpwd, roleId);
       return  admin;
    }

    public int addUser(Admin admin) {
        int i = adminMapper.insert(admin);
        return i;
    }

    public Admin getQuestionByUsername(String username) {

        Admin admin= adminMapper.selectQuestion(username);
        return  admin;
    }

    public Admin queryAdminByAnswer(String username, String answer) {

        Admin admin=adminMapper.queryAdmin(username,answer);
        return admin;
    }
}
