package com.ydgk.ssm.entities;

public class Admin {


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.userid
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.username
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.userpwd
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    private String userpwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.problem
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    private String problem;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.answer
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    private String answer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.rid
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    private Integer rid;

    private  Grade grade;


    @Override
    public String toString() {
        return "Admin{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", problem='" + problem + '\'' +
                ", answer='" + answer + '\'' +
                ", rid=" + rid +
                ", grade=" + grade +
                '}';
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.userid
     *
     * @return the value of admin.userid
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.userid
     *
     * @param userid the value for admin.userid
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.username
     *
     * @return the value of admin.username
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.username
     *
     * @param username the value for admin.username
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.userpwd
     *
     * @return the value of admin.userpwd
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public String getUserpwd() {
        return userpwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.userpwd
     *
     * @param userpwd the value for admin.userpwd
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.problem
     *
     * @return the value of admin.problem
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public String getProblem() {
        return problem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.problem
     *
     * @param problem the value for admin.problem
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.answer
     *
     * @return the value of admin.answer
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.answer
     *
     * @param answer the value for admin.answer
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.rid
     *
     * @return the value of admin.rid
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.rid
     *
     * @param rid the value for admin.rid
     *
     * @mbggenerated Thu Feb 13 15:07:00 CST 2020
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

}