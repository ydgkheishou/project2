<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/commons/common.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>修改学生成绩页面</title>
</head>
<body>

<div class="container">
    <div class="panel admin-panel margin-top">
        <div class="panel-head" id="add">
            <strong><h3><span class="icon ion-person-add margin-small"></span>学生成绩修改</h3></strong>
        </div>
        <div class="body-content">
            <form method="post" class="form-x"
                  action="${pageContext.request.contextPath}/admin/updateGrade">
                <div class="form-group">
                    <input hidden value="${pageNum}" name="pageNum">
                    <input hidden value="${admin.grade.gid}" name="gid"/>
                    <div class="label">
                        <label>学生姓名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="username" value="${admin.username}" readonly
                               <%--data-validate="required:请填写学生姓名!"--%>/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>第几次：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="number" value="${admin.grade.number}" readonly
                               <%--data-validate="required:语文成绩不能为空!"--%>/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <%--<label>java程序设计成绩：</label>--%>
                            <label>${courses.get(0).coursename}</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="gradeOne" value="${admin.grade.gradeOne}"
                               data-validate="required:${courses.get(0).coursename}成绩不能为空!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
<%--
                        <label>数据结构成绩：</label>
--%>
                        <label>${courses.get(1).coursename}</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="gradeTwo" value="${admin.grade.gradeTwo}"
                               data-validate="required:${courses.get(1).coursename}成绩不能为空!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
<%--
                        <label>高等代数成绩：</label>
--%>
                        <label>${courses.get(2).coursename}</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="gradeThree" value="${admin.grade.gradeThree}"
                               data-validate="required:${courses.get(2).coursename}成绩不能为空!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <%--  <div class="form-group">
                      <div class="label">
                          <label>总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分：</label>
                      </div>
                      <div class="field">
                          <input type="text" class="input w80" name="sum" value="${grade.sum}"
                          />
                          <div class="tips"></div>
                      </div>
                  </div>--%>
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit">
                            提交成绩
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

