package com.ydgk.ssm.entities;

/**
 * @author asus
 * @create 2019-12-12 17:07
 */
public class Grade {
private Integer gid;
private Integer gradeOne;
private Integer gradeTwo;
private Integer gradeThree;
private Integer sum;
private Integer number;
private Integer sid;

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gradeOne=" + gradeOne +
                ", gradeTwo=" + gradeTwo +
                ", gradeThree=" + gradeThree +
                ", sum=" + sum +
                ", number=" + number +
                ", sid=" + sid +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGradeOne() {
        return gradeOne;
    }

    public void setGradeOne(Integer gradeOne) {
        this.gradeOne = gradeOne;
    }

    public Integer getGradeTwo() {
        return gradeTwo;
    }

    public void setGradeTwo(Integer gradeTwo) {
        this.gradeTwo = gradeTwo;
    }

    public Integer getGradeThree() {
        return gradeThree;
    }

    public void setGradeThree(Integer gradeThree) {
        this.gradeThree = gradeThree;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
