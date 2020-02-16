<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/commons/common.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>修改用户页面</title>
    
</head>
<body>

<div class="container">
    <div class="panel admin-panel margin-top">
        <div class="panel-head" id="add">
            <strong><h3><span class="icon ion-person-add margin-small"></span>用户密码修改</h3></strong>
        </div>
        <div class="body-content">
            <form method="post" class="form-x"
                  action="${pageContext.request.contextPath}/admin/update">
                <div class="form-group">
                  <input hidden value="${requestScope.admin.userid}" name="userId"/>
                  <input hidden value="${pageNum}" name="pageNum"/>
                    <input hidden value="${roleid}" name="role">
                    <div class="label">
                        <label>用户名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="userName" value="${requestScope.admin.username}" readonly
                               data-validate="required:请填写用户名!"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>密码：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w80" name="userPassword" value="${admin.userpwd}"
                               data-validate="required:请填写密码!"/>
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
