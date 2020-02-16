<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/commons/common.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>课程注册页面</title>
  
</head>
<body>

<div class="container">
    <div class="panel admin-panel margin-top">
        <div class="panel-head" id="add">
            <strong><h3><span class="icon ion-person-add margin-small"></span>课程注册</h3></strong>
        </div>
        <div class="body-content">
            <form method="post" class="form-x"
                  action="${pageContext.request.contextPath}/admin/addCourse">
                <div class="form-group">
                    <div class="label">
                        <label>课程名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="coursename"
                               data-validate="required:请填写课程名!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>上课地点：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="courseclass"
                               data-validate="required:请填写上课地点!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>教师：</label>
                    </div>
                    <div class="field">
                        <select name="tid" id="tid">
                            <c:forEach var="admin" items="${admins}">
                                <option value="${admin.userid}">${admin.username}</option>
                            </c:forEach>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit">
                            提交
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>