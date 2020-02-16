package com.ydgk.ssm.mappers;

import com.ydgk.ssm.entities.Admin;
import com.ydgk.ssm.entities.AdminExample;
import java.util.List;

import com.ydgk.ssm.entities.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    Admin selectByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    int updateByPrimaryKey(Admin record);

    //角色管理模块按照角色进行模糊查询
    List<Admin> selectByRoleAndName(@Param("role") Integer role, @Param("name") String name);

    //初始化密码
    int updatePwd(int i);


    List<Admin> selectGrade(@Param("name") String name, @Param("number") Integer number);



    void delete(Integer gid);


    int toInsert(Grade grade);

    Admin selectInfo(Integer gid);

    void updateGrade(Grade grade);

    Admin queryInfo(@Param("loginName") String loginName, @Param("loginpwd") String loginpwd, @Param("roleId") String roleId);

    Admin selectQuestion(String username);

    Admin queryAdmin(@Param("username") String username, @Param("answer") String answer);
}